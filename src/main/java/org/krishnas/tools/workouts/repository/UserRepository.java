package org.krishnas.tools.workouts.repository;

import org.krishnas.tools.workouts.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByUserNameContaining(String name);
}
