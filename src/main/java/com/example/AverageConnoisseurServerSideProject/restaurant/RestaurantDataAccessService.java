package com.example.AverageConnoisseurServerSideProject.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.flywaydb.core.internal.jdbc.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("postgres")
public class RestaurantDataAccessService implements RestaurantDAO {

    @Autowired
    RestaurantRowMapper autowiredRowmapper;

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
                    SELECT * 
                    FROM restaurants
                    WHERE id = ?
                """;
        return jdbcTemplate.query(sql, autowiredRowmapper, id)
                .stream()
                .findFirst();
    }

    //METHOD BELOW NO LONGER IN USE
//    @Override
//    public Optional<List<Restaurant>> selectRestaurantFromCriteria(RestaurantCriteria restaurantCriteria) {
//        String sql = """
//                SELECT *
//                FROM restaurants
//                WHERE cuisine = ?
//                AND vegetarian = ?
//                AND halal = ?
//                AND glutenFree = ?
//                AND price >= ?
//                AND averageRating >= ?
//                ORDER BY averageRating DESC
//                """;
//        return Optional.of(jdbcTemplate.query(sql, autowiredRowmapper, restaurantCriteria.getCuisine(),
//                restaurantCriteria.isVegetarian(), restaurantCriteria.isIshalal(),
//                restaurantCriteria.isGlutenFree(), restaurantCriteria.getPrice(),
//                restaurantCriteria.getAverageRating()));
//    }


    @Override
        public void updateRestaurantAverageRating(long id, float averageRating){
            String sql = """
                   
                    UPDATE restaurants SET averageRating = ? WHERE id = ?;
                    """;
            jdbcTemplate.update(sql, averageRating, id);
        }

    @Override
    public List<Restaurant> getAllRestaurants() {
        String sql = """
                SELECT * 
                FROM restaurants
                ORDER BY averageRating DESC
                """;
        return jdbcTemplate.query(sql, autowiredRowmapper);
    }

    @Override
    public Optional<List<Restaurant>> selectRestaurantFromCriteria(String cuisineCondition, boolean vegCondition1, boolean vegCondition2, boolean halalCondition1, boolean halalCondition2, boolean glutenCondition1, boolean glutenCondition2, int priceCondition, float ratingCondition) {
        String sql = """
                SELECT * 
                FROM restaurants
                WHERE cuisine LIKE ?
                AND (vegetarian = ?
                OR vegetarian = ?)
                AND (halal = ?
                OR halal = ?)
                AND (glutenFree = ?
                OR glutenFree = ?)
                AND price <= ?
                AND averageRating >= ?
                ORDER BY averageRating DESC
                """;
        return Optional.of(jdbcTemplate.query(sql, autowiredRowmapper, "%" + cuisineCondition + "%", vegCondition1, vegCondition2,
        halalCondition1, halalCondition2, glutenCondition1, glutenCondition2, priceCondition, ratingCondition));
    }

}
