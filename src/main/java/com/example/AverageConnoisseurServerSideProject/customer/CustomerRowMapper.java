package com.example.AverageConnoisseurServerSideProject.customer;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerRowMapper implements RowMapper<Customer> {


    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer(
                rs.getString("CustomerName"),
                rs.getString("email"),
                rs.getInt("mobileNumber"),
                rs.getInt("id"),
                List.of());
                return customer;

    }
}
