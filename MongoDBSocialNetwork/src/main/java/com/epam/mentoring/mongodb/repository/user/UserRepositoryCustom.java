package com.epam.mentoring.mongodb.repository.user;


import java.util.List;

public interface UserRepositoryCustom {

    List<MovieResult> getMinNumberOfWatchedMoviesWhenHundredMoreFriends();
}
