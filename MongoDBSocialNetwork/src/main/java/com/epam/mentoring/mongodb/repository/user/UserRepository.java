package com.epam.mentoring.mongodb.repository.user;

import com.epam.mentoring.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom {
}
