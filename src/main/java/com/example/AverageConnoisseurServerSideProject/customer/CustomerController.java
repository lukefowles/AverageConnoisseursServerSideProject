package com.example.AverageConnoisseurServerSideProject.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("/customer")
@RestController
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    //Method which adds a customer object, passed into the method via the request body, to the database.
    //N.b. The customerID passed through the request body will likely change when added to the SQL database. A fix
    //for this could be to create another method in the service and data access service class which checks that a customer
    //with that email exists in the data-base, and if they don't adds the customer to the database, queries the database according
    //to their email, and then returns the new ID to the controller as part of the addCustomerToDatabase method.
    @PostMapping
    public void addCustomerToDatabase(@RequestBody Customer customer){
        customerService.addCustomerToDatabase(customer);
    }

    //Method to update a customer's information, according to their id, within the database.
    @PutMapping("{id}")
    public void updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer){
        customerService.updateCustomer(id, customer);
    }

    //Method to get a customer according to their id
    @GetMapping("{id}")
    public Optional<Customer> viewCustomer(@PathVariable("id") long id){
        return customerService.viewCustomer(id);

    }

    //Method to get a list of all customers
    @GetMapping
    public List<Customer> viewAllCustomers () {
        return customerService.viewAllCustomers();
    }

    //Method to delete a customer according to their id
    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable("id") long id){
        customerService.removeCustomerFromDatabase(id);
    }
}
