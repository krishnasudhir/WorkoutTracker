package org.krishnas.tools.workouts.controller;


import org.krishnas.tools.workouts.model.User;
import org.krishnas.tools.workouts.model.Workout;
import org.krishnas.tools.workouts.repository.UserRepository;
import org.krishnas.tools.workouts.repository.WorkoutRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class WorkoutController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    WorkoutRepository repository;

    @GetMapping("/workouts")
    public ResponseEntity<List<Workout>> getAllWorkouts() {
        logger.info("Fetch all Workouts");
        List<Workout> workouts = new ArrayList<>();
        workouts.addAll(repository.findAll());
        if (workouts.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(workouts, HttpStatus.OK);
    }

    @PutMapping("/workouts/{id}")
    public ResponseEntity<Workout> updateWork(@PathVariable("id") String id, @RequestBody Workout workout) {
        Optional<Workout> workoutData = repository.findById(id);

        if (workoutData.isPresent()) {
            Workout workoutToUpdate = workoutData.get();
            workoutToUpdate.update(workout);
            return new ResponseEntity<>(repository.save(workoutToUpdate), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/workouts/{id}")
    public ResponseEntity<HttpStatus> deleteWorkout(@PathVariable("id") String id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/workouts")
    public ResponseEntity<HttpStatus> deleteAllWorkouts() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/workouts")
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout) {
        try {
            Workout newWorkout = repository.save(new Workout(workout));
            return new ResponseEntity<>(newWorkout, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
