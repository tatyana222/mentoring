package com.epam.mentoring.webapp.controller;

import com.epam.mentoring.webapp.domain.User;
import com.epam.mentoring.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //-------------------Retrieve All Users--------------------------------------------------------

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> list() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
//
//
//
//    //-------------------Retrieve Single User--------------------------------------------------------
//
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
//        System.out.println("Fetching User with id " + id);
//        User user = userService.findById(id);
//        if (user == null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<User>(user, HttpStatus.OK);
//    }
//
//
//
//    //-------------------Create a User--------------------------------------------------------
//
//    @RequestMapping(value = "/user/", method = RequestMethod.POST)
//    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
//        System.out.println("Creating User " + user.getUsername());
//
//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//
//        userService.saveUser(user);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
//
//
//
//    //------------------- Update a User --------------------------------------------------------
//
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
//        System.out.println("Updating User " + id);
//
//        User currentUser = userService.findById(id);
//
//        if (currentUser==null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//
//        currentUser.setUsername(user.getUsername());
//        currentUser.setAddress(user.getAddress());
//        currentUser.setEmail(user.getEmail());
//
//        userService.updateUser(currentUser);
//        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
//    }
//
//
//
    //------------------- Delete a User --------------------------------------------------------

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);

        User user = userRepository.findOne(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userRepository.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
//
//
//
//    //------------------- Delete All Users --------------------------------------------------------
//
//    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
//    public ResponseEntity<User> deleteAllUsers() {
//        System.out.println("Deleting All Users");
//
//        userService.deleteAllUsers();
//        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//    }
}
