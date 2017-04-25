package com.epam.mentoring.rest.business.api;

import com.epam.mentoring.rest.user.User;

import java.io.IOException;
import java.io.InputStream;

public interface UserServiceLocal {

    User addUser(User user);

    Long updateUser(Long userId, User user) throws Exception;

    Long deleteUser(Long userId) throws Exception;

    String uploadLogo(Long userId, InputStream uploadedInputStream, String fileName) throws IOException;
}