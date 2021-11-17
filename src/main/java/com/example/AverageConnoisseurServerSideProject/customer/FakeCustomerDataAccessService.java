package com.example.AverageConnoisseurServerSideProject.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Fake data access service class we were using initially to demo our Spring Boot Application. Same with all
//fake data access service classes.
@Repository("Fake")
public class FakeCustomerDataAccessService implements CustomerDAO {
    private List<Customer> db = new ArrayList<>();

    public FakeCustomerDataAccessService(){
        db.add(new Customer("Henry", "henry@gmail.com", 074273, 1,  null));
        db.add(new Customer("Sarah", "sarah@gmail.com", 074555, 2,  null));
        db.add(new Customer("Mohamed", "mohamed@gmail.com", 074666, 3,  null));
    }

    public void addCustomerToDatabase(Customer customer){
        db.add(customer);
    }

    public void removeCustomerFromDatabase(long id){
        Optional<Customer> customer = db.stream().filter(person -> person.getId()==(id)).findAny();
        customer.ifPresent(person -> db.remove(person));
    }

    public Optional<Customer> viewCustomer(long id){
        Optional<Customer> customer = db.stream().filter(person -> person.getId()==(id)).findAny();
        return customer;
    }

    public void updateCustomer(long id, Customer customer){
        db.stream().forEach(p -> {
            if (id == p.getId()){
                p.setName(customer.getName());
                p.setEmail(customer.getEmail());
                p.setNumber(customer.getNumber());
            }
        });
    }

    @Override
    public List<Customer> viewAllCustomers() {
        return null;
    }
}
