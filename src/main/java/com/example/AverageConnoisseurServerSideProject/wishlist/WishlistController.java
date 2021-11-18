package com.example.AverageConnoisseurServerSideProject.wishlist;

import com.example.AverageConnoisseurServerSideProject.restaurant.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    private WishlistService wishlistService;

    @Autowired
    public WishlistController(WishlistService wishlistService) {this.wishlistService = wishlistService;}

    //Method to add a wishlisted restaurant to the database, passing in the customer and restaurant id
    @PostMapping ("{id}/{id2}")
    public void addRestaurantToWishlist(@PathVariable("id") long restaurant_ID, @PathVariable("id2") long customer_ID)
    {wishlistService.addRestaurantToWishlist(restaurant_ID, customer_ID);

    }

    //Method to get a wishlist based on customer_ID
    @GetMapping(path = "{id}")
    public List<Restaurant> getWishlist(@PathVariable("id") long customer_ID) {
        return wishlistService.getWishlist(customer_ID);
    }

    //Method to get all wishlisted items
    @GetMapping("/allWishlist")
    public List<Wishlist> getAllWishlisted() {
        return wishlistService.getAllWishlisted();
    }

    //Method to delete a restaurant from a wishlist based on customer and restaurant_ID
    @DeleteMapping ("{id}/{id2}")
    public void removeRestaurantFromWishlist(@PathVariable("id") long restaurant_ID, @PathVariable("id2") long customer_ID)
        {wishlistService.removeRestaurantFromWishlist(restaurant_ID, customer_ID);

    }
//    METHOD NOT IN USE
//    @GetMapping("{id}")
//    public Wishlist returnFavourite(long wishlist_ID)
//    {
//       return wishlistService.returnFavourite(wishlist_ID);
//    }
}
