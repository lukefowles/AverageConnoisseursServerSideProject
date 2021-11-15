package com.example.AverageConnoisseurServerSideProject.wishlist;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PostgresWishlist")
public class WishlistDataAccessService implements WishlistDAO {

    private JdbcTemplate jdbcTemplate;

    public WishlistDataAccessService(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public void addRestaurantToWishlist(long restaurant_ID, Wishlist wishlist) {
        String sql = """
                INSERT INTO wishlists(restaurant_ID, customer_ID,) VALUES(?, ?);
                """;

        jdbcTemplate.update(sql, wishlist.getRestaurant_ID(),
                wishlist.getCustomer_ID());
    }

    @Override
    public void removeRestaurantFromWishlist(long restaurant_ID, long customer_ID) {
    String sql = """
            DELETE FROM wishlists WHERE restaurant_ID = ? AND customer_ID = ?;
            """;
        jdbcTemplate.update(sql, restaurant_ID, customer_ID);
    }


    @Override
    public List<Wishlist> getWishlist(long customer_ID) {
        String sql = """
                SELECT * FROM wishlists INNER JOIN restaurants ON restaurant_ID = id WHERE customer_ID = ?;
                """;
        return jdbcTemplate.query(sql, new WishlistRowMapper(), customer_ID);
    }
}
