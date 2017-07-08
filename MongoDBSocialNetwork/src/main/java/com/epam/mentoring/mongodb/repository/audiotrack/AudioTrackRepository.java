package com.epam.mentoring.mongodb.repository.audiotrack;

import com.epam.mentoring.mongodb.model.AudioTrack;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AudioTrackRepository extends MongoRepository<AudioTrack, String> {
}
