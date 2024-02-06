package org.krishnas.tools.workouts.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "workout")
public class Workout {
    @Id
    private int userId;
    private String dateTime;
    private String category;
    private List<Exercise> exercises;


    public Workout(int userId, String dateTime, String category, List<Exercise> exercises) {
        this.userId = userId;
        this.dateTime = dateTime;
        this.category = category;
        this.exercises = exercises;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public Workout(){};
}
