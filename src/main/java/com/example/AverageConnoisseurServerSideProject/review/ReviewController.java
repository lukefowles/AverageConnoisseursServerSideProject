package com.example.AverageConnoisseurServerSideProject.review;

import com.example.AverageConnoisseurServerSideProject.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {this.reviewService = reviewService;}

    @PostMapping
    public void addReview(@RequestBody Review review){
        reviewService.addReview(review);
    }

    ///id???
    @PutMapping
    public void updateReview(long restaurant_ID, long customer_ID, @RequestBody Review review){
        reviewService.updateReview(restaurant_ID, customer_ID, review);
    }

    ///id?? 😦
    //changed return type to list
    @GetMapping
    public List<Review> getCustomerReviews(long customer_ID){
        return reviewService.getCustomerReviews(customer_ID);
    }

    @GetMapping
    public List<Review> getRestaurantReviews(long restaurant_ID){
        return reviewService.getRestaurantReviews(restaurant_ID);
    }

    @DeleteMapping
    //("{id}")??
    public void removeReview(long restaurant_ID, long customer_ID){
        reviewService.removeReview(restaurant_ID, customer_ID);
    }


}