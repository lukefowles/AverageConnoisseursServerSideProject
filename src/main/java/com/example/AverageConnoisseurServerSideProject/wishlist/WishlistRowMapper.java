package com.example.AverageConnoisseurServerSideProject.wishlist;

import com.example.AverageConnoisseurServerSideProject.restaurant.RestaurantDataAccessService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WishlistRowMapper implements RowMapper<Wishlist> {
    @Override
    public Wishlist mapRow(ResultSet rs, int rowNum) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        RestaurantDataAccessService restaurantDataAccessService = new RestaurantDataAccessService(jdbcTemplate);

        Wishlist wishlist = new Wishlist(
                rs.getInt("restaurant_ID"),
                rs.getInt("customer_ID"),
                rs.getInt("wishlist_ID"),
                restaurantDataAccessService.getRestaurantName(rs.getInt("id"))
        );
        return wishlist;
    }
}
