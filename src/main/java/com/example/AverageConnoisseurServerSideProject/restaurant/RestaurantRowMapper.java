package com.example.AverageConnoisseurServerSideProject.restaurant;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RestaurantRowMapper implements  RowMapper<Restaurant> {

    @Override
    public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
        Restaurant restaurant = new Restaurant(
                rs.getString("restaurantName"),
                rs.getString("restaurantAddress"),
                rs.getString("cuisine"),
                rs.getInt("price"),
                rs.getBoolean("vegetarian"),
                rs.getBoolean("halal"),
                rs.getBoolean("glutenFree"),
                rs.getFloat("averageRating"),
                rs.getInt("id"),
                List.of());
        return restaurant;
    }
}
