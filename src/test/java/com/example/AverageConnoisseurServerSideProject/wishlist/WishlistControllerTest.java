package com.example.AverageConnoisseurServerSideProject.wishlist;

import com.example.AverageConnoisseurServerSideProject.restaurant.Restaurant;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.*;


class WishlistControllerTest {

    private WishlistService wishlistService;

    private WishlistController underTest;

    @BeforeEach
    void setUp() {
        wishlistService = mock(WishlistService.class);
        underTest = new WishlistController(wishlistService);
    }

    @Test
    public void itCanAddRestaurantToWishlist() {
        //Given
        long restaurant_ID = 1;
        long customer_ID = 2;

        //When
        underTest.addRestaurantToWishlist(restaurant_ID, customer_ID);
        ArgumentCaptor<Long> restaurantIDCaptor = ArgumentCaptor.forClass(Long.class);
        ArgumentCaptor<Long> customerIDCaptor = ArgumentCaptor.forClass(Long.class);

        //Then
        verify(wishlistService).addRestaurantToWishlist(restaurantIDCaptor.capture(), customerIDCaptor.capture());
        Long arg1Sent = restaurantIDCaptor.getValue();
        Long arg2Sent =  customerIDCaptor.getValue();

        assertThat(arg1Sent).isEqualTo(restaurant_ID);
        assertThat(arg2Sent).isEqualTo(customer_ID);

    }

    @Test
    public void itCanRemoveRestaurantFromWishlist() {
        //given
        long restaurant_ID = 1;
        long customer_ID = 2;

        //when
        underTest.removeRestaurantFromWishlist(restaurant_ID, customer_ID);
        ArgumentCaptor<Long> restaurantIDCaptor = ArgumentCaptor.forClass(Long.class);
        ArgumentCaptor<Long> customerIDCaptor = ArgumentCaptor.forClass(Long.class);

        //then
        verify(wishlistService).removeRestaurantFromWishlist(restaurantIDCaptor.capture(), customerIDCaptor.capture());
        Long arg1Sent = restaurantIDCaptor.getValue();
        Long arg2Sent = customerIDCaptor.getValue();

        assertThat(arg1Sent).isEqualTo(restaurant_ID);
        assertThat(arg2Sent).isEqualTo(customer_ID);
    }

    @Test
    public void itCanGetWishlist(){
        //given
        long customer_ID = 1;
        Restaurant restaurant = new Restaurant("greggs",
                "1 high st","food",3,true,true,true,
                5, 1, null);
        when(wishlistService.getWishlist(customer_ID)).thenReturn(List.of(restaurant));


        //when

        List<Restaurant> restaurants = underTest.getWishlist(customer_ID);
        ArgumentCaptor<Long> customerIDCaptor = ArgumentCaptor.forClass(Long.class);

        //then
        verify(wishlistService).getWishlist(customerIDCaptor.capture());
        Long arg1Sent = customerIDCaptor.getValue();
        assertThat(arg1Sent).isEqualTo(customer_ID);
        assertThat(restaurants).isEqualTo(wishlistService.getWishlist(customer_ID));
    }
}