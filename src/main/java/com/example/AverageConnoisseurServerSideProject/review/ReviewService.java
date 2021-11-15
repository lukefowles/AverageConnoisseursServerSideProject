package com.example.AverageConnoisseurServerSideProject.review;

import com.example.AverageConnoisseurServerSideProject.restaurant.RestaurantDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private RestaurantDAO restaurantDAO;
    private ReviewDAO reviewDAO;

    public ReviewService(@Qualifier("FakeReviews") ReviewDAO reviewDAO, RestaurantDAO restaurantDAO) {
        this.reviewDAO = reviewDAO;
        this.restaurantDAO = restaurantDAO;    }

    public void addReview(Review review){
        reviewDAO.addReview(review);
        long newAverage = reviewDAO.calculateRestaurantAverageRating(review.getRestaurant_ID());
        restaurantDAO.updateRestaurantAverageRating(review.getRestaurant_ID(),newAverage);
    };

    public void removeReview(long review_ID, long restaurant_ID){
        reviewDAO.removeReview(review_ID, restaurant_ID);
        long newAverage = reviewDAO.calculateRestaurantAverageRating(restaurant_ID);
        restaurantDAO.updateRestaurantAverageRating(restaurant_ID,newAverage);
    };

    public List<Review> getCustomerReviews(long customer_ID){
        return reviewDAO.getCustomerReviews(customer_ID);
    };

    public List<Review> getRestaurantReviews(long restaurant_ID){
        return reviewDAO.getRestaurantReviews(restaurant_ID);
    };

    public void calculateRestaurantAverageRating(long id){
        reviewDAO.calculateRestaurantAverageRating(id);
    };

    public void updateReview(long review_ID, Review review){

        reviewDAO.updateReview(review_ID, review);
    };
}
