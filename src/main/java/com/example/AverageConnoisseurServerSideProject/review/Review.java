package com.example.AverageConnoisseurServerSideProject.review;

import java.util.Objects;

public class Review {
    private long review_ID;
    private long restaurant_ID;
    private long customer_ID;
    private float rating;
    private String comment;

    public Review(long review_ID, long restaurant_ID, long customer_ID, float rating, String comment) {
        this.review_ID = review_ID;
        this.restaurant_ID = restaurant_ID;
        this.customer_ID = customer_ID;
        this.rating = rating;
        this.comment = comment;
    }

    public long getReview_ID() {
        return review_ID;
    }

    public void setReview_ID(long review_ID) {
        this.review_ID = review_ID;
    }

    public long getRestaurant_ID() {
        return restaurant_ID;
    }

    public void setRestaurant_ID(long restaurant_ID) {
        this.restaurant_ID = restaurant_ID;
    }

    public long getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(long customer_ID) {
        this.customer_ID = customer_ID;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return review_ID == review.review_ID && restaurant_ID == review.restaurant_ID && customer_ID == review.customer_ID && Float.compare(review.rating, rating) == 0 && Objects.equals(comment, review.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(review_ID, restaurant_ID, customer_ID, rating, comment);
    }

    @Override
    public String toString() {
        return "Review{" +
                "review_ID=" + review_ID +
                ", restaurant_ID=" + restaurant_ID +
                ", customer_ID=" + customer_ID +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}