package org.krishnas.tools.workouts.model;

public class ExerciseSet {
    private int setID;
    private int repCount;
    private int weight;

    public ExerciseSet(){};

    public ExerciseSet(int setID, int reps, int weight){
        this.setID = setID;
        this.repCount = reps;
        this.weight = weight;
    }

    public int getSetID() {
        return setID;
    }

    public void setSetID(int setID) {
        this.setID = setID;
    }

    public int getRepCount() {
        return repCount;
    }

    public void setRepCount(int repCount) {
        this.repCount = repCount;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }




}
