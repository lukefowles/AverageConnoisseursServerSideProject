package com.example.AverageConnoisseurServerSideProject.customer;

import com.example.AverageConnoisseurServerSideProject.exceptions.ResourceNotFound;
import com.example.AverageConnoisseurServerSideProject.restaurant.RestaurantRowMapper;
import com.example.AverageConnoisseurServerSideProject.wishlist.WishlistRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository ("postgresCustomer")
public class CustomerDataAccessService implements CustomerDAO {

    @Autowired
    CustomerRowMapper autowiredRowmapper;

    private JdbcTemplate jdbcTemplate;

    public CustomerDataAccessService(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public void addCustomerToDatabase(Customer customer) {
        String sql = """
            INSERT INTO customers(id, customerName, email, mobileNumber)
            VALUES (?, ?, ?, ?);
            """;

        jdbcTemplate.update(sql, customer.getId(), customer.getName(), customer.getEmail(), customer.getNumber());
    }

    @Override
    public void removeCustomerFromDatabase(long id) {

            String sql = """
                DELETE FROM customers
                WHERE id = ?
                """;
            jdbcTemplate.update(sql, id);

    }

    @Override
    public Optional<Customer> viewCustomer(long id) {
        String sql = """
                SELECT * FROM customers
                WHERE id = ?
                """;

        return jdbcTemplate.query(sql, autowiredRowmapper, id)
                .stream()
                .findAny();
    }

    @Override
    public void updateCustomer(long id, Customer customer) {
        String sql = """
                UPDATE customers 
                SET customerName = ?, email = ?, mobileNumber = ?
                WHERE id = ?
                """;
        jdbcTemplate.update(sql, customer.getName(), customer.getEmail(),customer.getNumber(), customer.getId());

    }

    @Override
    public List<Customer> viewAllCustomers() {
        String sql = """
                SELECT *
                FROM customers
                """;
        return jdbcTemplate.query(sql, autowiredRowmapper);
    }
}
