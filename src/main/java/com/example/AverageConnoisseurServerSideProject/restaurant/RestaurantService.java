package com.example.AverageConnoisseurServerSideProject.restaurant;

import com.example.AverageConnoisseurServerSideProject.exceptions.ResourceNotFound;
import com.example.AverageConnoisseurServerSideProject.review.Review;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private RestaurantDAO restaurantDAO;

    public RestaurantService(@Qualifier("postgres") RestaurantDAO restaurantDAO) {
        this.restaurantDAO = restaurantDAO;
    };

    public void addRestaurant(Restaurant restaurant){

        restaurantDAO.addRestaurant(restaurant);

    };

    public void removeRestaurant(long id){

        if (restaurantDAO.getRestaurantName(id).isEmpty())
        {
            throw new ResourceNotFound("Restaurant with this id not found");
        }

        restaurantDAO.removeRestaurant(id);
    };

    public void updateRestaurant(long id, Restaurant restaurant){

        if (restaurantDAO.getRestaurantName(id).isEmpty())
        {
            throw new ResourceNotFound("Restaurant with this id not found");
        }

        restaurantDAO.updateRestaurant(id, restaurant);
    };

    public Optional<Restaurant> getRestaurantName(long id){

        if (restaurantDAO.getRestaurantName(id).isEmpty())
        {
            throw new ResourceNotFound("Restaurant with this id not found");
        }

        return restaurantDAO.getRestaurantName(id);
    };

    public Optional<List<Restaurant>> selectRestaurantFromCriteria(RestaurantCriteria restaurantCriteria) {

        if(restaurantDAO.selectRestaurantFromCriteria(restaurantCriteria).isEmpty())
        {
            throw new ResourceNotFound("No restaurants found matching these criteria");
        }
        return restaurantDAO.selectRestaurantFromCriteria(restaurantCriteria);
    }


    public void updateRestaurantAverageRating(long id, float newAverage){
        restaurantDAO.updateRestaurantAverageRating(id, newAverage);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantDAO.getAllRestaurants();
    }
}
