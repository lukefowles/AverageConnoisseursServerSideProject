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

    @PostMapping
    public void addRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.addRestaurant(restaurant);
    }

    @PutMapping("{id}")
    public void updateRestaurant(@PathVariable("id") long id, @RequestBody Restaurant restaurant){
        restaurantService.updateRestaurant(id, restaurant);
    }

    @GetMapping("{id}")
    public Optional<Restaurant> getRestaurantName(@PathVariable("id") long id){
        return restaurantService.getRestaurantName(id);
    }

    @DeleteMapping("{id}")
    public void removeRestaurant(@PathVariable("id") long id) {restaurantService.removeRestaurant(id);}

    @GetMapping("/criteria")
    public Optional<List<Restaurant>> selectRestaurantFromCriteria (@RequestBody RestaurantCriteria restaurantCriteria) {
       return restaurantService.selectRestaurantFromCriteria(restaurantCriteria);
    }

}
