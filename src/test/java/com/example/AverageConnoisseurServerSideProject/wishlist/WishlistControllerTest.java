package com.example.AverageConnoisseurServerSideProject.wishlist;

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

}