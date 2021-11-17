package com.example.AverageConnoisseurServerSideProject.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {this.restaurantService = restaurantService;}

    //Method to add restaurant
    @PostMapping
    public void addRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.addRestaurant(restaurant);
    }

    //Method to update restaurant according to its id
    @PutMapping("{id}")
    public void updateRestaurant(@PathVariable("id") long id, @RequestBody Restaurant restaurant){
        restaurantService.updateRestaurant(id, restaurant);
    }

    //method which gets a list of restaurants according to id (not name as alluded to in function name), sorted
    //by average rating
    @GetMapping("{id}")
    public Optional<Restaurant> getRestaurantName(@PathVariable("id") long id){
        return restaurantService.getRestaurantName(id);
    }

    //method which deletes a restaurant according to id
    @DeleteMapping("{id}")
    public void removeRestaurant(@PathVariable("id") long id) {restaurantService.removeRestaurant(id);}

    //method which searches for a restaurant based on criteria passed through the body as a RestaurantCriteria
    //JSON object.
    @GetMapping("/criteria")
    public Optional<List<Restaurant>> selectRestaurantFromCriteria (@RequestBody RestaurantCriteria restaurantCriteria) {
       return restaurantService.selectRestaurantFromCriteria(restaurantCriteria);
    }

    //method which gets a list of all restaurants
    @GetMapping("/allRestaurants")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

//    @PutMapping("/updaterating/{id}")
//    public void updateRestaurantAverageRating(@PathVariable("id") long id, float newAverage){
//        restaurantService.updateRestaurantAverageRating(id,newAverage);
//    }

}
