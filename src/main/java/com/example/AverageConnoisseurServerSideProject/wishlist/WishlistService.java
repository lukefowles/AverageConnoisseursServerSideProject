package com.example.AverageConnoisseurServerSideProject.wishlist;


import com.example.AverageConnoisseurServerSideProject.exceptions.ResourceNotFound;
import com.example.AverageConnoisseurServerSideProject.restaurant.Restaurant;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private WishlistDAO wishlistDAO;

    public WishlistService(@Qualifier("PostgresWishlist") WishlistDAO wishlistDAO) {

        this.wishlistDAO = wishlistDAO;
    }

    public void addRestaurantToWishlist (long restaurant_ID, long customer_ID)
    {
        wishlistDAO.addRestaurantToWishlist(restaurant_ID, customer_ID);}

    public void removeRestaurantFromWishlist (long restaurant_ID, long customer_ID)
    {
        wishlistDAO.removeRestaurantFromWishlist(restaurant_ID, customer_ID);
    }

    public List<Restaurant> getWishlist (long customer_ID){

        if (wishlistDAO.getWishlist(customer_ID).isEmpty()) {

            throw new ResourceNotFound("customer wishlist not found");
        }

        return wishlistDAO.getWishlist(customer_ID);
    }

    public List<Wishlist> getAllWishlisted() {
        return wishlistDAO.getAllWishlisted();
    }


//    public Wishlist returnFavourite(long wishlist_id) {
//        return wishlistDAO.returnFavourite(wishlist_id);
//    }
}
