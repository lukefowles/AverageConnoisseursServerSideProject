package com.example.AverageConnoisseurServerSideProject.review;

import com.example.AverageConnoisseurServerSideProject.exceptions.ResourceNotFound;
import com.example.AverageConnoisseurServerSideProject.restaurant.RestaurantDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private RestaurantDAO restaurantDAO;
    private ReviewDAO reviewDAO;

    public ReviewService(@Qualifier("PostgresReview") ReviewDAO reviewDAO, @Qualifier("postgres") RestaurantDAO restaurantDAO) {
        this.reviewDAO = reviewDAO;
        this.restaurantDAO = restaurantDAO;
    }

    public void addReview(Review review){
        //When review is added also need to calculate the new rating for the restaurant and update the restaurant
        //database
        reviewDAO.addReview(review);
        float newAverage = reviewDAO.calculateRestaurantAverageRating(review.getRestaurant_ID());
        restaurantDAO.updateRestaurantAverageRating(review.getRestaurant_ID(), newAverage);

    };

    public void removeReview(long review_ID, long restaurant_ID){
        //When review is removed also need to calculate the new rating for the restaurant and update the restaurant
        //database
        reviewDAO.removeReview(review_ID, restaurant_ID);
        float newAverage = reviewDAO.calculateRestaurantAverageRating(restaurant_ID);
        restaurantDAO.updateRestaurantAverageRating(restaurant_ID,newAverage);

    };

    public List<Review> getCustomerReviews(long customer_ID){

        return reviewDAO.getCustomerReviews(customer_ID);
    };

    public List<Review> getRestaurantReviews(long restaurant_ID){

        if(reviewDAO.getRestaurantReviews(restaurant_ID).isEmpty())
        {
            throw new ResourceNotFound("No reviews found");
        }
        return reviewDAO.getRestaurantReviews(restaurant_ID);
    };

    //METHOD NOT IN USE
//    public float calculateRestaurantAverageRating(long id){
//        reviewDAO.calculateRestaurantAverageRating(id);
//    };

    public void updateReview(long review_ID, Review review){

        reviewDAO.updateReview(review_ID, review);
        float newAverage = reviewDAO.calculateRestaurantAverageRating(review.getRestaurant_ID());
        restaurantDAO.updateRestaurantAverageRating(review.getRestaurant_ID(), newAverage);
    }

    public List<Review> getAllReviews() {

        return reviewDAO.getAllReviews();
    }
}
