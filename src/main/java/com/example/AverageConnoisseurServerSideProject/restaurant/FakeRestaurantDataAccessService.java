package com.example.AverageConnoisseurServerSideProject.restaurant;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("FakeRestaurantData")
public class FakeRestaurantDataAccessService implements RestaurantDAO {
    private List<Restaurant> db = new ArrayList<>();

    public FakeRestaurantDataAccessService() {
        db.add(new Restaurant("KFC", "43 Address, London, HA9 OTH", "Fast food", 1, false, true, false, 4.8F, 1, null));
        db.add(new Restaurant("Chasing Dragons", "66 Address, London, NW7 OTH", "Chinese", 1, false, true, false, 3.5F, 2, null));
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        db.add(restaurant);
    }

    @Override
    public void removeRestaurant(long id) {
       Optional<Restaurant> foundRestaurant = db.stream().filter(r -> r.getID() == id).findAny();
        foundRestaurant.ifPresent(r -> db.remove(r));
    }

    @Override
    public void updateRestaurant(long id, Restaurant restaurant) {
        db.stream().forEach(r -> {
            if (r.getID() == id){
                r.setRestaurantName(restaurant.getRestaurantName());
                r.setAddress(restaurant.getAddress());
                r.setCuisine(restaurant.getCuisine());
                r.setAverageRating(restaurant.getAverageRating());
                r.setGlutenFree(restaurant.isGlutenFree());
                r.setHalal(restaurant.isHalal());
                r.setVegetarian(restaurant.isVegetarian());
                r.setPrice(restaurant.getPrice());
                r.setReviews(restaurant.getReviews());
            }
        });
    }

    @Override
    public Optional<Restaurant> getRestaurantName(long id) {
        Optional<Restaurant> restaurant = db.stream().filter(r -> r.getID() == (id)).findAny();
        return restaurant;
    }

//    @Override
//    public Optional<List<Restaurant>> selectRestaurantFromCriteria(RestaurantCriteria restaurantCriteria) {
//        return Optional.of(db.stream().filter(r -> r.getCuisine().contains(restaurantCriteria.getCuisine())
//                                    && r.isVegetarian() == restaurantCriteria.isVegetarian()
//                                    && r.isHalal() == restaurantCriteria.isIshalal()
//                                    && r.isGlutenFree() == restaurantCriteria.isGlutenFree()
//                                    && r.getPrice() <= restaurantCriteria.getPrice()
//                                    && r.getAverageRating() >= restaurantCriteria.getAverageRating()
//                                    ).collect(Collectors.toList()));
//    }

    @Override

    public void updateRestaurantAverageRating(long id, float newAverage) {
    }
    public List<Restaurant> sortRestaurantsByRatings() {
        return null;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return null;
    }

    @Override
    public Optional<List<Restaurant>> selectRestaurantFromCriteria(String cuisineCondition, boolean vegCondition1, boolean vegCondition2, boolean halalCondition1, boolean halalCondition2, boolean glutenCondition1, boolean glutenCondition2, int priceCondition, float ratingCondition) {
        return Optional.empty();
    }
}

