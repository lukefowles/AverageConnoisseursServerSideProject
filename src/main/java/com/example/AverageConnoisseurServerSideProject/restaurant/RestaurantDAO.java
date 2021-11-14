package com.example.AverageConnoisseurServerSideProject.restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantDAO {

    public void addRestaurant(Restaurant restaurant);
    public void removeRestaurant(long id);
    public void updateRestaurant(long id, Restaurant restaurant);
    public Optional<Restaurant> getRestaurantName(long id);

    public Optional<List<Restaurant>> selectRestaurantFromCriteria(RestaurantCriteria restaurantCriteria);
}
