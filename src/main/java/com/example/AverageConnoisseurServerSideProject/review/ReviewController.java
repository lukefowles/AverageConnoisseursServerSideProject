package com.example.AverageConnoisseurServerSideProject.review;

import com.example.AverageConnoisseurServerSideProject.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {this.reviewService = reviewService;}

    //Method to add a new review with body representing a JSON representation of a review POJO
    @PostMapping
    public void addReview(@RequestBody Review review){
        reviewService.addReview(review);
    }

    //Method to update review according to review_ID
    @PutMapping("{id}")
    public void updateReview(@PathVariable("id") long review_ID, @RequestBody Review review){
        reviewService.updateReview(review_ID, review);
    }

    //Method to get reviews for a specific customer based on customer_ID
    @GetMapping(path = "customer/{id}")
    public List<Review> getCustomerReviews(@PathVariable("id") long customer_ID){
        return reviewService.getCustomerReviews(customer_ID);
    }

    //Method to get reviews for a restaurant based on restaurant_ID
    @GetMapping(path = "restaurant/{id}")
    public List<Review> getRestaurantReviews(@PathVariable("id") long restaurant_ID){
        return reviewService.getRestaurantReviews(restaurant_ID);
    }

    //Method to get all reviews from database
    @GetMapping("/allReviews")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    //Method to delete a review based off of review_ID and restaurant_ID
    @DeleteMapping("{id}/{id2}")
    public void removeReview(@PathVariable("id") long review_ID, @PathVariable("id2") long restaurant_ID){
        reviewService.removeReview(review_ID, restaurant_ID);
    }
//    METHOD NOT USED
//    @GetMapping
//    public void calculateRestaurantAverageRating(long id){
//        reviewService.calculateRestaurantAverageRating(id);
//    };
}