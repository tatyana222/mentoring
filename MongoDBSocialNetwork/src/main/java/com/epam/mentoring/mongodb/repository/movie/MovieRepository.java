package com.epam.mentoring.mongodb.repository.movie;

import com.epam.mentoring.mongodb.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
