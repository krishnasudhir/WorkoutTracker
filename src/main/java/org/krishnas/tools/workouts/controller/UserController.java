package org.krishnas.tools.workouts.controller;

import org.krishnas.tools.workouts.model.User;
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

public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository repository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String name) {
        logger.info("Fetch all Users");
        List<User> users = new ArrayList<>();

        if (name == null) {
            List<User> userList = repository.findAll();
            System.out.println("User list: \n" + userList);
            users.addAll(repository.findAll());
        }
        else
            users.addAll(repository.findByUserNameContaining(name));

        if (users.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // todo: Implement user add function
    // todo: Implemnent user update function
    // todo: Implement user delete function
}
