package com.example.AverageConnoisseurServerSideProject.restaurant;

import com.example.AverageConnoisseurServerSideProject.review.Review;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private RestaurantDAO restaurantDAO;

    public RestaurantService(@Qualifier("postgres") RestaurantDAO restaurantDAO) {this.restaurantDAO = restaurantDAO;};

    public void addRestaurant(Restaurant restaurant){
        restaurantDAO.addRestaurant(restaurant);
    };

    public void removeRestaurant(long id){
        restaurantDAO.removeRestaurant(id);
    };

    public void updateRestaurant(long id, Restaurant restaurant){
        restaurantDAO.updateRestaurant(id, restaurant);
    };

    public Optional<Restaurant> getRestaurantName(long id){
        return restaurantDAO.getRestaurantName(id);
    };

    public Optional<List<Restaurant>> selectRestaurantFromCriteria(RestaurantCriteria restaurantCriteria) {
        return restaurantDAO.selectRestaurantFromCriteria(restaurantCriteria);
    }


    public void updateRestaurantAverageRating(long id, float newAverage){
        restaurantDAO.updateRestaurantAverageRating(id, newAverage);
    }

//    public List<Restaurant> filterRestaurants(long restaurant_ID, float averageRating) {
//        List<Restaurant> ids = new ArrayList<>();
//        List<Restaurant> ratings = new ArrayList<>();
//
//        for (int i=0; i < ids.length; i++) {
//            if (// if restaurant id 1 is greater > equal then takes over)
//        } ids.add(restaurant_ID);
//        averageRating.add(restaurant);
//    }
//    int listOfRating = ids.size();
//    List<Restaurant> idx = new ArrayList<>(listOfRating);
//    for (int i=0; i < listORating; i++) {
//        idx.add("add rating of restaurant");
//    }
//    sort out ratings of code

    public List<Restaurant> sortRestaurantsByRatings(){
      return restaurantDAO.sortRestaurantsByRatings();
    }

}
