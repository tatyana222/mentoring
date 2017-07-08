package com.epam.mentoring.mongodb.repository.message;

import com.epam.mentoring.mongodb.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, Long>, MessageRepositoryCustom {

}
