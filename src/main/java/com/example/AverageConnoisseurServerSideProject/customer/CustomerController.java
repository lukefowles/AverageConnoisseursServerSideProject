package com.example.AverageConnoisseurServerSideProject.customer;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {
    private CustomerService customerService;

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

    @GetMapping
    public Optional<Customer> viewCustomer(@PathVariable("id") long id){
        return customerService.viewCustomer(id);

    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable("id") long id){
        customerService.removeCustomerFromDatabase(id);
    }
}
