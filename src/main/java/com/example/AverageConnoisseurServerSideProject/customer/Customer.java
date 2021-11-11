package com.example.AverageConnoisseurServerSideProject.customer;

import com.example.AverageConnoisseurServerSideProject.restaurant.Restaurant;

import java.util.List;
import java.util.Objects;

public class Customer {
    private String name;
    private String email;
    private long number;
    private long id;
    private List<Restaurant> wishlist;

    public Customer(String name, String email, long number, long id, List<Restaurant> wishlist) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.id = id;
        this.wishlist = wishlist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Restaurant> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<Restaurant> wishlist) {
        this.wishlist = wishlist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return number == customer.number && id == customer.id && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(wishlist, customer.wishlist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, number, id, wishlist);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", number=" + number +
                ", id=" + id +
                ", wishlist=" + wishlist +
                '}';
    }
}
