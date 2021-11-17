package com.example.AverageConnoisseurServerSideProject.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PostgresReview")
public class ReviewDataAccessService implements ReviewDAO {

    private JdbcTemplate jdbcTemplate;

    public ReviewDataAccessService(JdbcTemplate jdbctemplate) {this.jdbcTemplate = jdbctemplate;}


    @Override
    public void addReview(Review review) {
        String sql = """
                INSERT INTO reviews(restaurant_ID, customer_ID, rating, reviewComment) VALUES(?, ?, ?, ?);
                """;
        jdbcTemplate.update(sql, review.getRestaurant_ID(), review.getCustomer_ID(),
                review.getRating(),review.getComment());
    }

    @Override
    public void removeReview(long review_ID, long restaurant_ID) {
        String sql = """
                DELETE FROM reviews WHERE review_ID = ?;""";
        jdbcTemplate.update(sql, review_ID );

    }

    /// inner join added
    @Override
    public List<Review> getCustomerReviews(long customer_ID) {
        String sql = """
                SELECT * FROM reviews WHERE customer_ID = ?;""";
        return jdbcTemplate.query(sql, new ReviewRowMapper(), customer_ID);
    }

    @Override
    public List<Review> getRestaurantReviews(long restaurant_ID) {
        String sql = """
                SELECT * FROM reviews WHERE  restaurant_ID = ?;""";
        return jdbcTemplate.query(sql, new ReviewRowMapper(), restaurant_ID);
    }

    @Override
    public void updateReview(long review_ID, Review review) {
        String sql = """
                UPDATE reviews SET( rating, reviewComment) = (?, ?) WHERE review_ID = ?;""";
        jdbcTemplate.update(sql, review.getRating(), review.getComment(), review_ID);
    }

    @Override
    public float calculateRestaurantAverageRating(long id) {
        String sql = """
                SELECT AVG(rating) FROM reviews WHERE restaurant_ID = ?;
                """;
    //    long newAverage = 0;
        Float newAverage = jdbcTemplate.queryForObject(sql, Float.class, id);
        return newAverage;
    }

    @Override
    public void deleteReviewsByCustomer(long customer_ID) {
        String sql = """
                DELETE FROM reviews WHERE customer_ID = ?;""";
        jdbcTemplate.update(sql, customer_ID);
    }

    @Override
    public void deleteReviewsByRestaurant(long restaurant_ID) {
        String sql = """
                DELETE FROM reviews WHERE restaurant_ID = ?;""";
        jdbcTemplate.update(sql, restaurant_ID);
    }

    @Override
    public List<Review> getAllReviews() {
        String sql = """
                SELECT *
                FROM reviews""";
        return jdbcTemplate.query(sql, new ReviewRowMapper());
    }
}

