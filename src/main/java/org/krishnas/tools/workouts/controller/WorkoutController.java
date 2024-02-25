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
}
