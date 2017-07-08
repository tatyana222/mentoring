package com.epam.mentoring.mongodb.repository.friendship;

import com.epam.mentoring.mongodb.model.Friendship;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FriendshipRepository extends MongoRepository<Friendship, String>, FriendshipRepositoryCustom {
}
