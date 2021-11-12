package com.example.AverageConnoisseurServerSideProject.restaurant;

public interface RestaurantDAO {

    public void addRestaurant(Restaurant restaurant);
    public void removeRestaurant(long id);
    public void updateRestaurant(long id, Restaurant restaurant);
    public Restaurant getRestaurantName(long id);
}
