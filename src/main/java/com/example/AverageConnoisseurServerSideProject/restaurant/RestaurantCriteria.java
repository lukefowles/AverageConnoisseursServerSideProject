package com.example.AverageConnoisseurServerSideProject.restaurant;

import java.util.Objects;

public class RestaurantCriteria {

    private String cuisine;
    private boolean isVegetarian;
    private boolean ishalal;
    private boolean isGlutenFree;
    private int price;
    private float averageRating;

    public RestaurantCriteria(String cuisine, boolean isVegetarian, boolean ishalal, boolean isGlutenFree, int price, float averageRating) {
        this.cuisine = cuisine;
        this.isVegetarian = isVegetarian;
        this.ishalal = ishalal;
        this.isGlutenFree = isGlutenFree;
        this.price = price;
        this.averageRating = averageRating;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public boolean isIshalal() {
        return ishalal;
    }

    public void setIshalal(boolean ishalal) {
        this.ishalal = ishalal;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        isGlutenFree = glutenFree;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    @Override
    public String toString() {
        return "RestaurantCriteria{" +
                "cuisine='" + cuisine + '\'' +
                ", isVegetarian=" + isVegetarian +
                ", ishalal=" + ishalal +
                ", isGlutenFree=" + isGlutenFree +
                ", price=" + price +
                ", averageRating=" + averageRating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantCriteria that = (RestaurantCriteria) o;
        return isVegetarian == that.isVegetarian && ishalal == that.ishalal && isGlutenFree == that.isGlutenFree && price == that.price && Float.compare(that.averageRating, averageRating) == 0 && Objects.equals(cuisine, that.cuisine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuisine, isVegetarian, ishalal, isGlutenFree, price, averageRating);
    }
}
