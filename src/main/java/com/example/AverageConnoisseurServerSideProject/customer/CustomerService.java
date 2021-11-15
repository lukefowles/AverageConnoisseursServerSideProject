package com.example.AverageConnoisseurServerSideProject.customer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerService {

    private CustomerDAO customerDAO;

    public CustomerService(@Qualifier("Fake") CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    public void addCustomerToDatabase(Customer customer){
        customerDAO.addCustomerToDatabase(customer);
    }

    public void removeCustomerFromDatabase(long id){
        customerDAO.removeCustomerFromDatabase(id);
    }

    public Optional<Customer> viewCustomer(long id){
        return customerDAO.viewCustomer(id);
    }
    public void updateCustomer(long id, Customer customer){
        customerDAO.updateCustomer(id, customer);
    }


//    static void createCustomer(String name, String email, long number){
//
//    }
//
//    static void addReview(long ID, String restaurantName, int rating, String comment){
//
//    }
//
//    static void deleteCustomer(long ID){
//
//    }
//
//    static void addToWishlist(long ID, String restaurantName){
//
//    }
//
//    static void searchForRestaurant(){
//
//    }

    private Pattern regexPattern;
    private Matcher regMatcher;

    public String emailValidator(String email) {
        regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
        regMatcher = regexPattern.matcher(email);

        if(regMatcher.matches()) {
            return "Valid Email Address";
        } else {
            return "Invalid Email Address";
        }
    }

}
