package com.example.AverageConnoisseurServerSideProject.wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    private WishlistService wishlistService;

    @Autowired
    public WishlistController(WishlistService wishlist) {this.wishlistService = wishlistService;}

    @PostMapping
    public void addRestaurantToWishlist(@RequestBody long restaurant_ID, Wishlist wishlist)
    {wishlistService.addRestaurantToWishlist(restaurant_ID, wishlist);}


    @GetMapping(path = "wishlist/{id}")
    public List<Wishlist> getWishlist(@PathVariable("id") long customer_ID) {
        return wishlistService.getWishlist(customer_ID);
    }

    @DeleteMapping ("{id}")
    public void removeRestaurantFromWishlist(@PathVariable("id") long restaurant_ID, long customer_ID)
        {wishlistService.removeRestaurantFromWishlist(restaurant_ID, customer_ID);

    }
}
