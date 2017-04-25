package com.epam.mentoring.rest.client;

import com.epam.mentoring.rest.user.User;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;

import static javax.ws.rs.client.Entity.entity;

public class RESTClient {

    private static final String REST_URI = "http://localhost:8080/rest/users";
    private static final String CONSOLE_SEPARATOR = "************************************";
    private static final String RESPONSE_STATUS_MESSAGE = "Response status: ";
    // Absolute path in file system. Please change it to test
    private static final String DOWNLOADED_PATH = "/home/aurora/downloaded/";

    public static void main(String[] args) throws IOException {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(REST_URI);

        User createdUser = post(webTarget);
        System.out.println(CONSOLE_SEPARATOR);

        createdUser.setEmail("new_email@email.com");
        put(createdUser, webTarget);
        System.out.println(CONSOLE_SEPARATOR);

        Long userId = createdUser.getId();
        uploadLogo(userId);
        System.out.println(CONSOLE_SEPARATOR);

        downloadLogo(userId, "Smiley1.png");
        System.out.println(CONSOLE_SEPARATOR);

        delete(userId, webTarget);

        client.close();
    }

    private static User post(WebTarget webTarget) {
        User user = new User();
        user.setFirstName("First name");
        user.setLastName("Last name");
        user.setLogin("user555");
        user.setEmail("user@email.com");

        System.out.println("POST request to create new User");

        Response response = webTarget.request().post(entity(user, MediaType.APPLICATION_XML), Response.class);

        System.out.println(RESPONSE_STATUS_MESSAGE + response.getStatus());
        User createdUser = response.readEntity(User.class);
        System.out.println("Created User: " + createdUser);
        System.out.println("Created User id: " + createdUser.getId());

        response.close();
        return createdUser;
    }

    private static void put(User user, WebTarget webTarget) {
        Long userId = user.getId();
        System.out.println("PUT request to update User with id " + userId);

        Response response = webTarget.path(String.valueOf(userId)).request()
                .put(entity(user, MediaType.APPLICATION_JSON), Response.class);

        System.out.println(RESPONSE_STATUS_MESSAGE + response.getStatus());
        System.out.println("Updated User id: " + response.readEntity(String.class));

        response.close();
    }

    private static void uploadLogo(Long userId) throws IOException {
        System.out.println("Upload logo for User with id " + userId);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File logoPath = new File(classLoader.getResource("images/Smiley1.png").getFile());

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(MultiPartFeature.class);
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget webTarget = client.target(REST_URI);

        try (FormDataMultiPart formDataMultiPart = new FormDataMultiPart()) {

            FileDataBodyPart fileDataBodyPart = new FileDataBodyPart("file", logoPath, MediaType.APPLICATION_OCTET_STREAM_TYPE);
            formDataMultiPart.bodyPart(fileDataBodyPart);

            String servicePath = String.valueOf(userId) + "/logos";
            Response response = webTarget.path(servicePath).request()
                    .post(entity(formDataMultiPart, MediaType.MULTIPART_FORM_DATA), Response.class);

            System.out.println(RESPONSE_STATUS_MESSAGE + response.getStatus());
            System.out.println("Path to User logo: " + response.readEntity(String.class));

            response.close();

        } finally {
            client.close();
        }
    }

    private static void downloadLogo(Long userId, String fileName) throws IOException {
        System.out.println("Download logo for User with id " + userId);

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(MultiPartFeature.class);
        Client client = ClientBuilder.newClient(clientConfig);
        client.property("accept", "image/png");
        WebTarget webTarget = client.target(REST_URI);

        String servicePath = String.valueOf(userId) + "/logos/" + fileName;
        Response response = webTarget.path(servicePath).request().get();

        System.out.println(RESPONSE_STATUS_MESSAGE + response.getStatus());

        String responseMessage = response.getStatusInfo().getReasonPhrase();
        System.out.println("Response message from server: " + responseMessage);

        InputStream inputStream = response.readEntity(InputStream.class);
        String pathToFile = DOWNLOADED_PATH + fileName;

        try (OutputStream outputStream = new FileOutputStream(pathToFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("User logo has been successfully downloaded to location: " + pathToFile);

        } finally {
            response.close();
            client.close();
        }
    }

    private static void delete(Long userId, WebTarget webTarget) {
        System.out.println("DELETE request to delete User with id " + userId);

        Response response = webTarget.path(String.valueOf(userId)).request().delete();

        System.out.println(RESPONSE_STATUS_MESSAGE + response.getStatus());
        System.out.println("Deleted User id: " + response.readEntity(String.class));

        response.close();
    }
}