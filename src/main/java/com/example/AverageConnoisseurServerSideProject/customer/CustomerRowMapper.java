package com.example.AverageConnoisseurServerSideProject.customer;

import com.example.AverageConnoisseurServerSideProject.review.ReviewDAO;
import com.example.AverageConnoisseurServerSideProject.wishlist.WishlistDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//Row mapper class to map SQL columns to a new Customer object.
@Component
public class CustomerRowMapper implements RowMapper<Customer> {

    @Autowired
    @Qualifier("PostgresWishlist")
    WishlistDAO wishlistDAO;
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer(
                rs.getString("CustomerName"),
                rs.getString("email"),
                rs.getInt("mobileNumber"),
                rs.getInt("id"),
                wishlistDAO.getWishlist(rs.getInt("id")));
                return customer;

    }
}
