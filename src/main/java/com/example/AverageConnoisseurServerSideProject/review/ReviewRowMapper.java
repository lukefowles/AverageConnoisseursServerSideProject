package com.example.AverageConnoisseurServerSideProject.review;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewRowMapper implements RowMapper<Review> {

    @Override
    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
        Review review = new Review (
                rs.getInt("review_ID"),
        rs.getInt("restaurant_ID"),
        rs.getInt("customer_ID"),
        rs.getInt("rating"),
        rs.getString("reviewComment")
        );
        return review;    }
}
