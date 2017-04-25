package com.epam.mentoring.rest.business.impl;

import com.epam.mentoring.rest.business.api.UserServiceLocal;
import com.epam.mentoring.rest.user.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class UserServiceBean implements UserServiceLocal {

    // Absolute path in file system. Please change it to test
    private static final String UPLOADED_PATH = "/home/aurora/uploaded/";
    private static Map<Long, User> users = new HashMap<>();

    @Override
    public User addUser(User user) {
        Long userId = ThreadLocalRandom.current().nextLong(100);
        user.setId(userId);
        users.put(userId, user);
        return user;
    }

    @Override
    public Long updateUser(Long userId, User user) throws Exception {
        if (users.get(userId) != null) {
            users.put(userId, user);
            return userId;
        } else {
            throw new Exception("Update failed: User with id " + userId + " is not found");
        }
    }

    @Override
    public Long deleteUser(Long userId) throws Exception {
        if (users.get(userId) != null) {
            users.remove(userId);
            return userId;
        } else {
            throw new Exception("Delete failed: User with id " + userId + " is not found");
        }
    }

    @Override
    public String uploadLogo(Long userId, InputStream uploadedInputStream, String fileName) throws IOException {
        String fileLocation = UPLOADED_PATH + fileName;
        File file = new File(fileLocation);

        try (OutputStream out = new FileOutputStream(file)) {

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();

            users.get(userId).setLogoLocation(fileLocation);
        }
        return fileLocation;
    }
}