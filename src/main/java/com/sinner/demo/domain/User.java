package com.sinner.demo.domain;

public class User {
    String username;
    int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public User() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void save(){
        System.out.println(username);
        System.out.println(age);
    }
}
