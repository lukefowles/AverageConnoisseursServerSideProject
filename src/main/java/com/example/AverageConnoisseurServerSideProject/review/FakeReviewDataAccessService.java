package com.example.AverageConnoisseurServerSideProject.review;

import com.example.AverageConnoisseurServerSideProject.customer.Customer;
import com.example.AverageConnoisseurServerSideProject.customer.FakeCustomerDataAccessService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("FakeReviews")
public class FakeReviewDataAccessService implements ReviewDAO {
    private List<Review> reviewdb = new ArrayList<>();

    public FakeReviewDataAccessService(){
        reviewdb.add(new Review(1,2,1,4,"good service"));
        reviewdb.add(new Review(2,3,2,1,"food was cold"));
        reviewdb.add(new Review(3,4,3,0,"i was robbed"));

    }

    public void addReview(Review review) {
        reviewdb.add(review);
    }

    @Override
    public void removeReview(long review_ID, long restaurant_ID) {

    }

    public void removeReview(long review_ID){
        Optional<Review> review = reviewdb.stream().filter(r -> (r.getReview_ID()==(review_ID))).findAny();
        review.ifPresent(r -> reviewdb.remove(r));
    }

    public List<Review>  getCustomerReviews(long customer_ID){
        List<Review> customerReviews = reviewdb.stream().filter(review -> review.getCustomer_ID()==(customer_ID)).toList();
        return customerReviews;
    }

    public List<Review>  getRestaurantReviews(long restaurant_ID){
        List<Review> restaurantReviews = reviewdb.stream().filter(review -> review.getRestaurant_ID()==(restaurant_ID)).toList();
        return restaurantReviews;
    }


    public void updateReview(long review_ID, Review review){
        reviewdb.stream().forEach(r -> {
            if(review_ID == r.getReview_ID() ){
                r.setRating(review.getRating());
                r.setComment(review.getComment());
            }
        });
    }

    @Override
    public float calculateRestaurantAverageRating(long id) {
        return 0;
    }

    @Override
    public void deleteReviewsByCustomer(long customer_ID) {

    }

    @Override
    public void deleteReviewsByRestaurant(long restaurant_ID) {

    }

    @Override
    public List<Review> getAllReviews() {
        return null;
    }

}