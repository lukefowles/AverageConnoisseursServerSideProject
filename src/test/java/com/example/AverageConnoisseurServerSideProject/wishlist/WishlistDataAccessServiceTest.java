package com.example.AverageConnoisseurServerSideProject.wishlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WishlistDataAccessServiceTest {

    private JdbcTemplate jdbcTemplate;
    private WishlistDataAccessService underTest;

    @BeforeEach
    void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
        underTest = new WishlistDataAccessService(jdbcTemplate);
    }


    @Test
    public void doesAddRestuarantToCustomerWishlist() {

        //Given
        long restaurant_ID = 1;
        long customer_ID = 2;
        String sql = """
                INSERT INTO wishlists(restaurant_ID, customer_ID) VALUES(?, ?);
                """;

        ArgumentCaptor<String> sqlCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Long> restaurantIDCaptor = ArgumentCaptor.forClass(Long.class);
        ArgumentCaptor<Long> customerIDCaptor = ArgumentCaptor.forClass(Long.class);

        //When
        underTest.addRestaurantToWishlist(restaurant_ID, customer_ID);
        Mockito.verify(jdbcTemplate).update( sqlCaptor.capture(), restaurantIDCaptor.capture(), customerIDCaptor.capture());
        String sqlArgument =  sqlCaptor.getValue();
        Long restaurantIDArgument = restaurantIDCaptor.getValue();
        Long customerIDArgument = customerIDCaptor.getValue();

        //Then
        assertThat(sqlArgument).isEqualTo(sql);
        assertThat(restaurantIDArgument).isEqualTo(restaurant_ID);
        assertThat(customerIDArgument).isEqualTo(customer_ID);



    }

}