package com.example.demo;

public class Show {
    private final String title;
    private final String review;
    private final Integer rating;

    public Show(String title, String review) {
        this.title = title;
        this.review = review;
        this.rating = (int)(Math.random() * 1000);
    }

    public String getTitle() {
        return title;
    }

    public String getReview() {
        return review;
    }

    public Integer getRating() {
        return rating;
    }
}
