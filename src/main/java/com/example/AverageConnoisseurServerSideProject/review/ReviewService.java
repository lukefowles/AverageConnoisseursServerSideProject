package com.example.AverageConnoisseurServerSideProject.review;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private ReviewDAO reviewDAO;

    public ReviewService(@Qualifier("FakeReviews") ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;
    }

    public void addReview(Review review){
        reviewDAO.addReview(review);
    };

    public void removeReview(long review_ID){
        reviewDAO.removeReview(review_ID);
    };

    /// return type changed to list
    public List<Review> getCustomerReviews(long customer_ID){
        return reviewDAO.getCustomerReviews(customer_ID);
    };

    public List<Review> getRestaurantReviews(long restaurant_ID){
        return reviewDAO.getRestaurantReviews(restaurant_ID);
    };

    public void updateReview(long review_ID, Review review){
        reviewDAO.updateReview(review_ID, review);
    };
}