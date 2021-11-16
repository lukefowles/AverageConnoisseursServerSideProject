package com.example.AverageConnoisseurServerSideProject.wishlist;

import com.example.AverageConnoisseurServerSideProject.restaurant.RestaurantDAO;
import com.example.AverageConnoisseurServerSideProject.restaurant.RestaurantDataAccessService;
import com.example.AverageConnoisseurServerSideProject.review.ReviewDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class WishlistRowMapper implements RowMapper<Wishlist> {
    @Autowired
    @Qualifier("postgres")
    RestaurantDAO restaurantDAO;
    @Override
    public Wishlist mapRow(ResultSet rs, int rowNum) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        RestaurantDataAccessService restaurantDataAccessService = new RestaurantDataAccessService(jdbcTemplate);

        Wishlist wishlist = new Wishlist(
                rs.getInt("restaurant_ID"),
                rs.getInt("customer_ID"),
                rs.getInt("wishlist_ID"),
                restaurantDAO.getRestaurantName(rs.getInt("restaurant_ID"))
        );
        return wishlist;
    }
}
