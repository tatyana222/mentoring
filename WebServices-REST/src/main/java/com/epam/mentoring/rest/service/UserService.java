package com.epam.mentoring.rest.service;

import com.epam.mentoring.rest.business.api.UserServiceLocal;
import com.epam.mentoring.rest.business.impl.UserServiceBean;
import com.epam.mentoring.rest.user.User;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/users")
public class UserService {

    private UserServiceLocal service = new UserServiceBean();

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(User user) throws URISyntaxException {
        User createdUser = service.addUser(user);
        return Response.created(new URI("/users/" + user.getId())).entity(createdUser).build();
    }

    @PUT
    @Path("/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("userId") Long userId, User user) {
        try {
            Long updatedUserId = service.updateUser(userId, user);
            return Response.ok(updatedUserId).build();
        } catch (Exception e) {
            return Response.status(404).build();
        }

    }

    @DELETE
    @Path("/{userId}")
    public Response delete(@PathParam("userId") Long userId) {
        try {
            Long deletedUserId = service.deleteUser(userId);
            return Response.ok(deletedUserId).build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }

    @POST
    @Path("/{userId}/logos")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadLogo(@PathParam("userId") Long userId,
                               @FormDataParam("file") InputStream uploadedInputStream,
                               @FormDataParam("file") FormDataContentDisposition fileDetails) throws IOException {

        String fileName = fileDetails.getFileName();
        String uploadedLogoLocation = service.uploadLogo(userId, uploadedInputStream, fileName);
        return Response.ok().entity(uploadedLogoLocation).build();
    }

    @GET
    @Path("/{userId}/logos/{name}")
    @Produces({"image/png", "image/jpg", "image/gif"})
    public Response downloadLogo(@PathParam("userId") Long userId, @PathParam("name") String logoName) {

        File file = new File(logoName);
        return Response.ok(file).header("Content-Disposition", "attachment; filename=" + logoName).build();
    }
}