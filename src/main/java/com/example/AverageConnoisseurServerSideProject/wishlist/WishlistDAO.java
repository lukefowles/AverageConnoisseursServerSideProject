package com.example.AverageConnoisseurServerSideProject.wishlist;


import java.util.List;

public interface WishlistDAO {

    public void addRestaurantToWishlist(long restaurant_ID, long customer_ID);
    public void removeRestaurantFromWishlist(long restaurant_ID, long customer_ID);
    public List<Wishlist> getWishlist(long customer_ID);
}
