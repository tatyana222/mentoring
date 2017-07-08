package com.epam.mentoring.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "messages")
public class Message {

    @Id
    private String id;
    private String content;
    private LocalDateTime creationDate;

    public Message() {
    }

    public Message(String content, LocalDateTime creationDate) {
        this.content = content;
        this.creationDate = creationDate;
    }
}
