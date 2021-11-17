package com.example.AverageConnoisseurServerSideProject.restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantDAO {

    public void addRestaurant(Restaurant restaurant);
    public void removeRestaurant(long id);
    public void updateRestaurant(long id, Restaurant restaurant);
    public Optional<Restaurant> getRestaurantName(long id);

//    public Optional<List<Restaurant>> selectRestaurantFromCriteria(RestaurantCriteria restaurantCriteria);

    public void updateRestaurantAverageRating(long id, float newAverage);

    List<Restaurant> getAllRestaurants();

    Optional<List<Restaurant>> selectRestaurantFromCriteria(String cuisineCondition, boolean vegCondition1, boolean vegCondition2, boolean halalCondition1, boolean halalCondition2, boolean glutenCondition1, boolean glutenCondition2, int priceCondition, float ratingCondition);
}
