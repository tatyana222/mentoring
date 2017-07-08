package com.epam.mentoring.mongodb.repository.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;

public class UserRepositoryImpl implements UserRepositoryCustom {

    private static final String WATCHED_MOVIES = "watchedMovies";
    private static final String NUMBER_OF_MOVIES = "numberOfMovies";

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<MovieResult> getMinNumberOfWatchedMoviesWhenHundredMoreFriends() {
        Aggregation aggregation = newAggregation(
                match(where(WATCHED_MOVIES).gt(EMPTY_LIST).and("friends").gt(EMPTY_LIST)),
                project("id").and(WATCHED_MOVIES).size().as(NUMBER_OF_MOVIES),
                group().min(NUMBER_OF_MOVIES).as("minNumberOfMovies")
        );

        AggregationResults<MovieResult> results = mongoTemplate.aggregate(aggregation, "users", MovieResult.class);
        return results.getMappedResults();
    }
}
