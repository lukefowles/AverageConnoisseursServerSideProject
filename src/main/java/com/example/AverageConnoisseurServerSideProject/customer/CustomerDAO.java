package com.example.AverageConnoisseurServerSideProject.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {
    void addCustomerToDatabase(Customer customer);
    void removeCustomerFromDatabase(long id);
    Optional<Customer> viewCustomer(long id);
    void updateCustomer(long id, Customer customer);
    List<Customer> viewAllCustomers();
}
