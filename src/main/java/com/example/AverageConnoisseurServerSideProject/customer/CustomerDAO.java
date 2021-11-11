package com.example.AverageConnoisseurServerSideProject.customer;

import java.util.Optional;

public interface CustomerDAO {
    public void addCustomerToDatabase(Customer customer);
    public void removeCustomerFromDatabase(long id);
    public Optional<Customer> viewCustomer(long id);
    public void updateCustomer(long id, Customer customer);
    //    public void addRestaurantToWishlist(); > stretch goal

}
