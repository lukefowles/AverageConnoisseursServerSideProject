package com.example.AverageConnoisseurServerSideProject.review;

import com.example.AverageConnoisseurServerSideProject.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {this.reviewService = reviewService;}

    @PostMapping
    public void addReview(@RequestBody Review review){
        reviewService.addReview(review);
    }

    @PutMapping("{id}")
    public void updateReview(@PathVariable("id") long review_ID, @RequestBody Review review){
        reviewService.updateReview(review_ID, review);
    }

    @GetMapping(path = "customer/{id}")
    public List<Review> getCustomerReviews(@PathVariable("id") long customer_ID){
        return reviewService.getCustomerReviews(customer_ID);
    }

    @GetMapping(path = "restaurant/{id}")
    public List<Review> getRestaurantReviews(@PathVariable("id") long restaurant_ID){
        return reviewService.getRestaurantReviews(restaurant_ID);
    }

    @DeleteMapping("{id}")
    public void removeReview(@PathVariable("id") long review_ID){
        reviewService.removeReview(review_ID);
    }


}