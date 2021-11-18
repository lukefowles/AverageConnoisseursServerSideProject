package com.example.AverageConnoisseurServerSideProject.review;

import java.util.List;

public interface ReviewDAO {

    public void addReview(Review review);
    public void removeReview(long review_ID, long restaurant_ID);
    public List<Review> getCustomerReviews(long customer_ID);
    public List<Review> getRestaurantReviews(long restaurant_ID);
    public void updateReview(long review_ID, Review review);
    public float calculateRestaurantAverageRating(long id);

    void deleteReviewsByCustomer(long customer_ID);

    void deleteReviewsByRestaurant(long restaurant_ID);

    List<Review> getAllReviews();
}