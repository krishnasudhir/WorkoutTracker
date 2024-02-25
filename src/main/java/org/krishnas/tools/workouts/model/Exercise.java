package org.krishnas.tools.workouts.model;

import java.util.HashMap;
import java.util.List;

public class Exercise {

    private String exerciseCat;

    List<ExerciseSet> exerciseSets;

    public String getExerciseCat() {
        return exerciseCat;
    }

    public void setExerciseCat(String exerciseCat) {
        this.exerciseCat = exerciseCat;
    }

    public List<ExerciseSet> getExerciseSets() {
        return exerciseSets;
    }

    public void setExerciseSets(List<ExerciseSet> exerciseSets) {
        this.exerciseSets = exerciseSets;
    }

    public Exercise(){};



}
