package com.example.AverageConnoisseurServerSideProject.wishlist;

import com.example.AverageConnoisseurServerSideProject.exceptions.ResourceNotFound;
import com.example.AverageConnoisseurServerSideProject.restaurant.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WishlistServiceTest {

    private WishlistDAO wishlistDAO;
    private WishlistService underTest;

    @BeforeEach
    void setUp() {
        wishlistDAO = mock(WishlistDAO.class);
        underTest = new WishlistService(wishlistDAO);

    }

    @Test
    void canAddRestaurantToWishlist() {
        //Given
        long restaurant_ID = 2;
        long customer_ID = 1;

        //When
        underTest.addRestaurantToWishlist(restaurant_ID, customer_ID);
        ArgumentCaptor<Long> restaurantIDCaptor = ArgumentCaptor.forClass(Long.class);
        ArgumentCaptor<Long> customerIDCaptor = ArgumentCaptor.forClass(Long.class);

        //Then
        verify(wishlistDAO).addRestaurantToWishlist(restaurantIDCaptor.capture(), customerIDCaptor.capture());
        Long arg1Sent = restaurantIDCaptor.getValue();
        Long arg2Sent =  customerIDCaptor.getValue();

        assertThat(arg1Sent).isEqualTo(restaurant_ID);
        assertThat(arg2Sent).isEqualTo(customer_ID);
    }

    @Test
    void canRemoveRestaurantFromWishlist() {
        //Given
        long restaurant_ID = 3;
        long customer_ID = 3;

        //When
        underTest.removeRestaurantFromWishlist(restaurant_ID, customer_ID);
        ArgumentCaptor<Long> restaurantIDCaptor = ArgumentCaptor.forClass(Long.class);
        ArgumentCaptor<Long> customerIDCaptor = ArgumentCaptor.forClass(Long.class);

        //Then
        verify(wishlistDAO).removeRestaurantFromWishlist(restaurantIDCaptor.capture(), customerIDCaptor.capture());
        Long arg1Sent = restaurantIDCaptor.getValue();
        Long arg2Sent =  customerIDCaptor.getValue();

        assertThat(arg1Sent).isEqualTo(restaurant_ID);
        assertThat(arg2Sent).isEqualTo(customer_ID);
    }

    @Test
    void canGetWishlist() {
        //Given
        long customer_ID = 1;
        Restaurant restaurant = new Restaurant("greggs",
                "1 high st","food",3,true,true,true,
                5, 1, null);
        when(wishlistDAO.getWishlist(customer_ID)).thenReturn(List.of(restaurant));

        //When
        List<Restaurant> restaurants = underTest.getWishlist(customer_ID);
        ArgumentCaptor<Long> customerIDCaptor = ArgumentCaptor.forClass(Long.class);


        //Then
        verify(wishlistDAO, times(2)).getWishlist(customerIDCaptor.capture());
        Long arg1Sent = customerIDCaptor.getValue();

        assertThat(arg1Sent).isEqualTo(customer_ID);
        assertThat(restaurants).isEqualTo(wishlistDAO.getWishlist(customer_ID));

    }

    @Test
     void returnsErrorIfNoWishlistFound(){

        //Given
        long customer_ID = 1;
        Restaurant restaurant = new Restaurant("greggs",
                "1 high st","food",3,true,true,true,
                5, 1, null);
        when(wishlistDAO.getWishlist(customer_ID)).thenReturn(List.of());


        //Then
        assertThatThrownBy(()-> underTest.getWishlist(customer_ID)).hasMessage("customer wishlist not found").isInstanceOfAny(ResourceNotFound.class);
    }
}