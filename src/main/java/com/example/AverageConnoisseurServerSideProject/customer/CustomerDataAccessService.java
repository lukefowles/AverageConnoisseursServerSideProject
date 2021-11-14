package com.example.AverageConnoisseurServerSideProject.customer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository ("postgresCustomer")
public class CustomerDataAccessService implements CustomerDAO {

    private JdbcTemplate jdbcTemplate;

    public CustomerDataAccessService(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public void addCustomerToDatabase(Customer customer) {
        String sql = """
            INSERT INTO customers(customerName, email, mobileNumber)
            VALUES (?, ?, ?);
            """;

        jdbcTemplate.update(sql, customer.getName(), customer.getEmail(), customer.getNumber());
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

        return jdbcTemplate.query(sql, new CustomerRowMapper(), id)
                .stream()
                .findAny();
    }

    @Override
    public void updateCustomer(long id, Customer customer) {
        String sql = """
                UPDATE customers 
                SET customerName = ?, email = ?, mobileNumber = ?, id = ?
                WHERE id = ?
                """;
        jdbcTemplate.update(sql, customer.getName(), customer.getNumber(), customer.getEmail(), customer.getId());

    }
}
