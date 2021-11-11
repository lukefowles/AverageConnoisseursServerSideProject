package com.example.AverageConnoisseurServerSideProject.review;

import java.util.Objects;

public class Review {
    private long restaurant_ID;
    private long customer_ID;
    private int rating;
    private String comment;

    public Review(long restaurant_ID, long customer_ID, int rating, String comment) {
        this.restaurant_ID = restaurant_ID;
        this.customer_ID = customer_ID;
        this.rating = rating;
        this.comment = comment;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "restaurant_ID=" + restaurant_ID +
                ", customer_ID=" + customer_ID +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return restaurant_ID == review.restaurant_ID && customer_ID == review.customer_ID && rating == review.rating && Objects.equals(comment, review.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurant_ID, customer_ID, rating, comment);
    }
}
