package com.example.AverageConnoisseurServerSideProject.wishlist;

import com.example.AverageConnoisseurServerSideProject.restaurant.Restaurant;

import java.util.Objects;
import java.util.Optional;

//Wishlist class. Each instance of class wishlist represents one item on the customer's wishlist, and not the entire wishlist
//itself
public class Wishlist {

    private long restaurant_ID;
    private long customer_ID;
    private long wishlist_ID;
    private Optional<Restaurant>restaurant;


    public Wishlist(long restaurant_ID, long customer_ID, long wishlist_ID, Optional<Restaurant> restaurant) {
        this.restaurant_ID = restaurant_ID;
        this.customer_ID = customer_ID;
        this.wishlist_ID = wishlist_ID;
        this.restaurant = restaurant;
    }

    public long getRestaurant_ID() {
        return restaurant_ID;
    }

    public long getCustomer_ID() {
        return customer_ID;
    }

    public long getWishlist_ID() {
        return wishlist_ID;
    }

    public Optional<Restaurant> getRestaurant() {
        return restaurant;
    }

    public void setRestaurant_ID(long restaurant_ID) {
        this.restaurant_ID = restaurant_ID;
    }

    public void setCustomer_ID(long customer_ID) {
        this.customer_ID = customer_ID;
    }

    public void setWishlist_ID(long wishlist_ID) {
        this.wishlist_ID = wishlist_ID;
    }

    public void setRestaurant(Optional<Restaurant> restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wishlist wishlist = (Wishlist) o;
        return restaurant_ID == wishlist.restaurant_ID && customer_ID == wishlist.customer_ID && wishlist_ID == wishlist.wishlist_ID && Objects.equals(restaurant, wishlist.restaurant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurant_ID, customer_ID, wishlist_ID, restaurant);
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "restaurant_ID=" + restaurant_ID +
                ", customer_ID=" + customer_ID +
                ", wishlist_ID=" + wishlist_ID +
                ", restaurant=" + restaurant +
                '}';
    }
}
