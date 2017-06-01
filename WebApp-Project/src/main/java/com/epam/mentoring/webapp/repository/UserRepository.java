package com.epam.mentoring.webapp.repository;

import com.epam.mentoring.webapp.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
}
