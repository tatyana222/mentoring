package com.epam.mentoring.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String login;
    private String firstName;
    private String lastName;
    private LocalDateTime birthday;

    private List<User> friends;
    private List<Message> messages;
    private List<Movie> movies;
    private List<Movie> watchedMovies;
    private List<AudioTrack> audioTracks;

    public User() {
    }

    public User(String login, String firstName, String lastName, LocalDateTime birthday, List<User> friends) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.friends = friends;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(List<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }
}
