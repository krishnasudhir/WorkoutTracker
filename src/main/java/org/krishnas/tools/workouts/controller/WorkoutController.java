package org.krishnas.tools.workouts.controller;


import org.krishnas.tools.workouts.model.User;
import org.krishnas.tools.workouts.model.Workout;
import org.krishnas.tools.workouts.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class WorkoutController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository repository;

    @GetMapping("/users")
    public ResponseEntity<List<Workout>> getAllWorkouts(@RequestParam(required = false) String workout) {
        logger.info("Fetch all Workouts");
        List<Workout> workouts = new ArrayList<>();

        if (workout == null) {
            List<User> workoutList = repository.findAll();
            System.out.println("Workout list: \n" + workouts);
            //workouts.addAll(repository.findAll());
        }
//        else
//            workouts.addAll(repository.findByUserNameContaining(workout));

        if (workouts.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(workouts, HttpStatus.OK);
    }
}
