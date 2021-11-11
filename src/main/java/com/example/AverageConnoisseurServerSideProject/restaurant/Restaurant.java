package com.example.AverageConnoisseurServerSideProject.restaurant;

import com.example.AverageConnoisseurServerSideProject.review.Review;

import java.util.List;
import java.util.Objects;

public class Restaurant {


    private String restaurantName;
    private String address;
    private String cuisine;
    private int price;
    private boolean vegetarian;
    private boolean halal;
    private boolean glutenFree;
    private float averageRating;
    private long ID;
    private List<Review> reviews;

    public Restaurant(String restaurantName, String address, String cuisine, int price, boolean vegetarian, boolean halal, boolean glutenFree, float averageRating, long ID, List<Review> reviews) {
        this.restaurantName = restaurantName;
        this.address = address;
        this.cuisine = cuisine;
        this.price = price;
        this.vegetarian = vegetarian;
        this.halal = halal;
        this.glutenFree = glutenFree;
        this.averageRating = averageRating;
        this.ID = ID;
        this.reviews = reviews;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isHalal() {
        return halal;
    }

    public void setHalal(boolean halal) {
        this.halal = halal;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return price == that.price && vegetarian == that.vegetarian && halal == that.halal && glutenFree == that.glutenFree && Float.compare(that.averageRating, averageRating) == 0 && ID == that.ID && Objects.equals(restaurantName, that.restaurantName) && Objects.equals(address, that.address) && Objects.equals(cuisine, that.cuisine) && Objects.equals(reviews, that.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantName, address, cuisine, price, vegetarian, halal, glutenFree, averageRating, ID, reviews);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantName='" + restaurantName + '\'' +
                ", address='" + address + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", price=" + price +
                ", vegetarian=" + vegetarian +
                ", halal=" + halal +
                ", glutenFree=" + glutenFree +
                ", averageRating=" + averageRating +
                ", ID=" + ID +
                ", reviews=" + reviews +
                '}';
    }
}
