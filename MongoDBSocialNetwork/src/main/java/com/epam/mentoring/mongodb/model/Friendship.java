package com.epam.mentoring.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "friendships")
public class Friendship {

    @Id
    private String id;
    private User user;
    private User actionUser;
    private LocalDateTime creationDate;

    public Friendship() {
    }

    public Friendship(User user, User actionUser, LocalDateTime creationDate) {
        this.user = user;
        this.actionUser = user;
        this.creationDate = creationDate;
    }
}
