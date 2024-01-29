package org.krishnas.tools.workouts.repository;

import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByNameContaining(String name);
}
