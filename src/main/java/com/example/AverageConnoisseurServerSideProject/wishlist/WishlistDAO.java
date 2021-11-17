package com.example.AverageConnoisseurServerSideProject.wishlist;


import com.example.AverageConnoisseurServerSideProject.restaurant.Restaurant;

import java.util.List;

public interface WishlistDAO {

    public void addRestaurantToWishlist(long restaurant_ID, long customer_ID);
    public void removeRestaurantFromWishlist(long restaurant_ID, long customer_ID);
    public List<Restaurant> getWishlist(long customer_ID);
    public void removeWishlistWithRestaurantID(long restaurant_ID);
    public void removeWishlistWithCustomerID(long customer_ID);
}
