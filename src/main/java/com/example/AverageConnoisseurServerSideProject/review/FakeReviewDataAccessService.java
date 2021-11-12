package com.example.AverageConnoisseurServerSideProject.review;

import com.example.AverageConnoisseurServerSideProject.customer.FakeCustomerDataAccessService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("FakeReviews")
public class FakeReviewDataAccessService implements ReviewDAO {
    private List<Review> reviewdb = new ArrayList<>();

    public FakeReviewDataAccessService(){
        reviewdb.add(new Review(2,1,4,"good service"));
        reviewdb.add(new Review(3,2,1,"food was cold"));
        reviewdb.add(new Review(4,3,0,"i was robbed"));

    }

    public void addReview(Review review) {
        reviewdb.add(review);
    }

    ///do we need a stream?
    public void removeReview(Review review){
        reviewdb.remove(review);
    }

//    public List<Reviews>  getCustomerReviews(long customer_ID){
//        List<Review> customerReviews = reviewdb.stream().filter(review -> review.getCustomer_ID()==(customer_ID);
//        return customerReviews;
//    }

    //getRestaurantReviews

    public void updateReview(long restaurant_ID, long customer_ID, Review review){
        reviewdb.stream().forEach(r -> {
            if((restaurant_ID == r.getRestaurant_ID()) &&(customer_ID == r.getCustomer_ID())){
                r.setRating(review.getRating());
                r.setComment(review.getComment());
            }
        });
    }

}