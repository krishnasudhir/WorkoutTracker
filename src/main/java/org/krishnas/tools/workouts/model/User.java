package org.krishnas.tools.workouts.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    @Id
    private String userId;
    private String userName;
    private String gender;
    private int age;
    private int weight;
    private String createDate;

    public User(String userName){
        this.userName = userName;
        this.gender = null;
        this.age = 0;
        this.weight = 0;
        this.createDate = null;
    }

    public User(){}

    public User(String userName, String gender, int age, int weight, String date){
        this.userName = userName;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.createDate = date;
    }

    public User(User user){
        this.userName = user.userName;
        this.gender = user.gender;
        this.age = user.age;
        this.weight = user.weight;
        this.createDate = user.createDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
