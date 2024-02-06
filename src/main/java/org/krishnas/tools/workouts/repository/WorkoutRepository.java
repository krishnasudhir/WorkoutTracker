package org.krishnas.tools.workouts.repository;

import org.krishnas.tools.workouts.model.User;
import org.krishnas.tools.workouts.model.Workout;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WorkoutRepository extends MongoRepository<Workout, String> {

}
