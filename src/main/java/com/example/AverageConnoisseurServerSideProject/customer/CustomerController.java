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

    @PostMapping
    public void addCustomerToDatabase(@RequestBody Customer customer){
        customerService.addCustomerToDatabase(customer);
    }

    @PutMapping("{id}")
    public void updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer){
        customerService.updateCustomer(id, customer);
    }

    @GetMapping("{id}")
    public Optional<Customer> viewCustomer(@PathVariable("id") long id){
        return customerService.viewCustomer(id);

    }

    @GetMapping
    public List<Customer> viewAllCustomers () {
        return customerService.viewAllCustomers();
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable("id") long id){
        customerService.removeCustomerFromDatabase(id);
    }
}
