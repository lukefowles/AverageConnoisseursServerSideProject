package com.example.AverageConnoisseurServerSideProject.wishlist;


import com.example.AverageConnoisseurServerSideProject.restaurant.Restaurant;

import java.util.List;

public interface WishlistDAO {

    public void addRestaurantToWishlist(long restaurant_ID, long customer_ID);
    public void removeRestaurantFromWishlist(long restaurant_ID, long customer_ID);
    public List<Restaurant> getWishlist(long customer_ID);

    void removeWishlistWithCustomerID(long id);

    void removeWishlistWithRestaurantID(long id);

    List<Wishlist> getAllWishlisted();
}
