package org.krishnas.tools.workouts.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String user_id;
    private String user_name;
    private String gender;
    private int age;
    private int weight;
    private String date;

    public User(String user_name){
        this.user_name = user_name;
        this.gender = null;
        this.age = 0;
        this.weight = 0;
        this.date = null;
    }

    public User(String user_name, String gender, int age, int weight, String date){
        this.user_name = user_name;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.date = date;
    }

    public User(User user){
        this.user_name = user.user_name;
        this.gender = user.gender;
        this.age = user.age;
        this.weight = user.weight;
        this.date = user.date;
    }

    public String getUser_name() {
        return user_name;
    }

}
