package com.epam.mentoring.mongodb.model;

import org.springframework.data.annotation.Id;

public class AudioTrack {

    @Id
    private String id;
    private String singerName;
    private String name;
    private String url;
}
