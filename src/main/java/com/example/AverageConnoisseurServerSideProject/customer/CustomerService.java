package com.example.AverageConnoisseurServerSideProject.customer;

import com.example.AverageConnoisseurServerSideProject.exceptions.ResourceNotFound;
import com.example.AverageConnoisseurServerSideProject.review.ReviewDAO;
import com.example.AverageConnoisseurServerSideProject.wishlist.WishlistDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerService {

    private CustomerDAO customerDAO;
    private WishlistDAO wishlistDAO;
    private ReviewDAO reviewDAO;

    public CustomerService(@Qualifier("postgresCustomer") CustomerDAO customerDAO, @Qualifier("PostgresWishlist")
            WishlistDAO wishlistDAO, @Qualifier("PostgresReview") ReviewDAO reviewDAO){
        this.wishlistDAO = wishlistDAO;
        this.reviewDAO = reviewDAO;
        this.customerDAO = customerDAO;
    }

    public void addCustomerToDatabase(Customer customer){

        customerDAO.addCustomerToDatabase(customer);
    }

    public void removeCustomerFromDatabase(long id){

        if (customerDAO.viewCustomer(id).isEmpty())
        {
            throw new ResourceNotFound("Person with this id does not exist");
        }

        //Call methods to delete reviews and wishlists from the database for that customer
        wishlistDAO.removeWishlistWithCustomerID(id);
        reviewDAO.deleteReviewsByCustomer(id);
        customerDAO.removeCustomerFromDatabase(id);
    }

    public Optional<Customer> viewCustomer(long id){
        if (customerDAO.viewCustomer(id).isEmpty())
        {
            throw new ResourceNotFound("Person with this id not found");
        }
        return customerDAO.viewCustomer(id);
    }

    public void updateCustomer(long id, Customer customer){

        if (customerDAO.viewCustomer(id).isEmpty())
        {
            throw new ResourceNotFound("Person with this id does not exist");
        }

        customerDAO.updateCustomer(id, customer);
    }

    public List<Customer> viewAllCustomers() {

        return customerDAO.viewAllCustomers();
    }



    //Email validator not in use
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
