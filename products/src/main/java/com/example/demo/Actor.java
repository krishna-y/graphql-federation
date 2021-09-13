package com.example.demo;

public class Actor {
    private final String name;
    private final Integer age;

    public Actor(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
