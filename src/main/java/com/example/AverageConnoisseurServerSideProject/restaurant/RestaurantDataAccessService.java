package com.example.AverageConnoisseurServerSideProject.restaurant;

import org.springframework.jdbc.core.JdbcTemplate;
import org.flywaydb.core.internal.jdbc.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("postgres")
public class RestaurantDataAccessService implements RestaurantDAO {

    private JdbcTemplate jdbcTemplate;

    public RestaurantDataAccessService(JdbcTemplate jdbctemplate) {this.jdbcTemplate = jdbctemplate;}


    @Override
    public void addRestaurant(Restaurant restaurant) {
        String sql = """
                INSERT INTO restaurants(restaurantName, cuisine, restaurantAddress,
                vegetarian, halal, glutenFree, price, averageRating) 
                VALUES(?, ?, ?, ?, ?, ?, ?, ?);
                """;

        jdbcTemplate.update(sql, restaurant.getRestaurantName(), restaurant.getCuisine(),
                restaurant.getAddress(), restaurant.isVegetarian(), restaurant.isHalal(),
                restaurant.isGlutenFree(), restaurant.getPrice(), restaurant.getAverageRating());
    }

    @Override
    public void removeRestaurant(long id) {
        String sql = """
                DELETE FROM restaurants 
                WHERE id = ?
                """;
        jdbcTemplate.update(sql, id);

    }

    @Override
    public void updateRestaurant(long id, Restaurant restaurant) {
        String sql = """
                UPDATE restaurants
                SET restaurantName = ?, cuisine = ?, restaurantAddress = ?,
                vegetarian = ?, halal = ?, glutenFree = ?, price = ?,
                averageRating = ?
                WHERE id = ?
                """;
                jdbcTemplate.update(sql, restaurant.getRestaurantName(), restaurant.getCuisine(),
                        restaurant.getAddress(), restaurant.isVegetarian(), restaurant.isHalal(),
                        restaurant.isGlutenFree(), restaurant.getPrice(), restaurant.getAverageRating(), id);
    }


    @Override
    public Optional<Restaurant> getRestaurantName(long id) {
        String sql = """
                    SELECT review_ID, restaurant_ID, customer_ID, rating,
                    comment, restaurantName, restaurantAddress, cuisine, vegetarian,
                    halal, glutenFree, price, averageRating 
                    FROM restaurants 
                    INNER JOIN reviews
                    ON restaurants.id = reviews.restaurant_ID;
                    WHERE id = ?
                """;
        return jdbcTemplate.query(sql, new RestaurantRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public Optional<List<Restaurant>> selectRestaurantFromCriteria(RestaurantCriteria restaurantCriteria) {
        String sql = """
                SELECT 
                review_ID,
                restaurant_ID,
                customer_ID,
                rating,
                comments,
                restaurantName,
                restaurantAddress,
                cuisine,
                vegetarian,
                halal,
                glutenFree,
                price,
                averageRatings
                FROM restaurants 
                INNER JOIN Reviews
                ON restaurants.id = reviews.restaurants_ID
                WHERE cuisine = ?
                AND vegetarian = ?
                AND halal = ?
                AND glutenFree = ?
                AND price >= ?
                AND averageRating >= ?
                ORDER BY averageRating DESC
                """;
        return Optional.of(jdbcTemplate.query(sql, new RestaurantRowMapper(), restaurantCriteria.getCuisine(),
                restaurantCriteria.isVegetarian(), restaurantCriteria.isIshalal(),
                restaurantCriteria.isGlutenFree(), restaurantCriteria.getPrice(),
                restaurantCriteria.getAverageRating()));
    }


        @Override
        public void updateRestaurantAverageRating(long id, float averageRating){
            String sql = """
                   
                    UPDATE restaurants SET averageRating = ? WHERE id = ?;
                    """;
            jdbcTemplate.update(sql, averageRating, id);
        }

    @Override
    public List<Restaurant> sortRestaurantsByRatings(){
        String sql = """
                SELECT 
                review_ID,
                restaurant_ID,
                customer_ID,
                rating,
                comments,
                restaurantName,
                restaurantAddress,
                cuisine,
                vegetarian,
                halal,
                glutenFree,
                price,
                averageRatings
                FROM restaurants 
                INNER JOIN Reviews
                ON restaurants.id = reviews.restaurants_ID
                ORDER BY averageRating DESC
                """;
        return jdbcTemplate.query(sql, new RestaurantRowMapper());

    }

}
