package com.example.AverageConnoisseurServerSideProject.restaurant;


import com.example.AverageConnoisseurServerSideProject.review.Review;
import com.example.AverageConnoisseurServerSideProject.review.ReviewDataAccessService;
import com.example.AverageConnoisseurServerSideProject.review.ReviewRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RestaurantRowMapper implements  RowMapper<Restaurant> {

    @Override
    public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
        JdbcTemplate jdbctemplate = new JdbcTemplate();
        ReviewDataAccessService reviewDataAccessService = new ReviewDataAccessService(jdbctemplate);
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
                reviewDataAccessService.getRestaurantReviews(rs.getInt("id")));
        return restaurant;
    }
}
