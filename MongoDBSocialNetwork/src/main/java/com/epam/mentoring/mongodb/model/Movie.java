package com.epam.mentoring.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movies")
public class Movie {

    @Id
    private String id;
    private String name;
    private String description;
    private String url;

    public Movie() {
    }

    public Movie(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public String getId() {
        return id;
    }
}
