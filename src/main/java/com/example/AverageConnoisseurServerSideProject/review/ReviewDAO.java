package com.example.AverageConnoisseurServerSideProject.review;

import java.util.List;

public interface ReviewDAO {

    public void addReview(Review review);
    public void removeReview(long restaurant_ID, long customer_ID);
    //changed return typr to list
    public List<Review> getCustomerReviews(long customer_ID);
    public List<Review> getRestaurantReviews(long restaurant_ID);
    public void updateReview(long restaurant_ID, long customer_ID, Review review);

}