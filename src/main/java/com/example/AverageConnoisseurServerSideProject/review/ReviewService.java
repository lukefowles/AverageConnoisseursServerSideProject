package com.example.AverageConnoisseurServerSideProject.review;

import java.util.List;

public class ReviewService {

    private ReviewDAO reviewDAO;

    public ReviewService(ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;
    }

    public void addReview(Review review){
        reviewDAO.addReview(review);
    };

    public void removeReview(long restaurant_ID, long customer_ID){
        reviewDAO.removeReview(restaurant_ID, customer_ID);
    };

    /// return type changed to list
    public List<Review> getCustomerReviews(long customer_ID){
        return reviewDAO.getCustomerReviews(customer_ID);
    };

    public List<Review> getRestaurantReviews(long restaurant_ID){
        return reviewDAO.getRestaurantReviews(restaurant_ID);
    };

    public void updateReview(long restaurant_ID, long customer_ID, Review review){
        reviewDAO.updateReview(restaurant_ID, customer_ID, review);
    };
}