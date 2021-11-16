package com.example.AverageConnoisseurServerSideProject.wishlist;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private WishlistDAO wishlistDAO;

    public void addRestaurantToWishlist (@Qualifier("PostgresWishlist") long restaurant_ID, Wishlist wishlist)
    { wishlistDAO.addRestaurantToWishlist(restaurant_ID, wishlist);}

    public void removeRestaurantFromWishlist (long restaurant_ID, long customer_ID)
    { wishlistDAO.removeRestaurantFromWishlist(restaurant_ID, customer_ID);}

    public List<Wishlist> getWishlist (long customer_ID){
        return wishlistDAO.getWishlist(customer_ID);
    }


}
