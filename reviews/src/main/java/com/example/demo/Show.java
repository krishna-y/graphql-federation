package com.example.demo;

public class Show {
    private final String title;
    private final Integer rating;

    public Show(String title) {
        this.title = title;
        this.rating = (int)(Math.random() * 1000);
    }

    public String getTitle() {
        return title;
    }


    public Integer getRating() {
        return rating;
    }
}
