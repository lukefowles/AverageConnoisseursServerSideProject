package com.example.AverageConnoisseurServerSideProject.wishlist;

import com.example.AverageConnoisseurServerSideProject.restaurant.Restaurant;
import com.example.AverageConnoisseurServerSideProject.restaurant.RestaurantRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WishlistDataAccessServiceTest {

    private JdbcTemplate jdbcTemplate;
    private WishlistDataAccessService underTest;
    private RestaurantRowMapper restaurantRowMapper;

    @BeforeEach
    void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
//        restaurantRowMapper = mock(RestaurantRowMapper.class);
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

    @Test
    public void canRemoveRestaurantFromCustomerWishlist() {

        //Given
        long restaurant_ID = 1;
        long customer_ID = 2;
        String sql = """
            DELETE FROM wishlists WHERE restaurant_ID = ? AND customer_ID = ?;
            """;

        ArgumentCaptor<String> sqlCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Long> restaurantIDCaptor = ArgumentCaptor.forClass(Long.class);
        ArgumentCaptor<Long> customerIDCaptor = ArgumentCaptor.forClass(Long.class);

        //When
        underTest.removeRestaurantFromWishlist(restaurant_ID, customer_ID);
        Mockito.verify(jdbcTemplate).update( sqlCaptor.capture(), restaurantIDCaptor.capture(), customerIDCaptor.capture());
        String sqlArgument =  sqlCaptor.getValue();
        Long restaurantIDArgument = restaurantIDCaptor.getValue();
        Long customerIDArgument = customerIDCaptor.getValue();

        //Then
        assertThat(sqlArgument).isEqualTo(sql);
        assertThat(restaurantIDArgument).isEqualTo(restaurant_ID);
        assertThat(customerIDArgument).isEqualTo(customer_ID);

    }

    @Test
    public void getRestaurantsFromCustomerWishlist() {
        //Given
        long customer_ID = 1;
        String sql = """
                SELECT * 
                FROM wishlists
                RIGHT JOIN restaurants
                ON wishlists.restaurant_id = restaurants.id
                WHERE customer_ID = ?;
                """;
        Restaurant restaurant = new Restaurant("greggs",
                "1 high st","food",3,true,true,true,
                5, 1, null);
        ArgumentCaptor<Long> customerIDCaptor = ArgumentCaptor.forClass(Long.class);
        ArgumentCaptor<String> sqlCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<RestaurantRowMapper> restaurantRowMapperArgumentCaptor = ArgumentCaptor.forClass(RestaurantRowMapper.class);

        when(jdbcTemplate.query(sql, restaurantRowMapper, customer_ID)).thenReturn(List.of(restaurant));
        List<Restaurant> expected = List.of(restaurant);

        //When
        List <Restaurant> actual = underTest.getWishlist(customer_ID);
        Mockito.verify(jdbcTemplate).query(sqlCaptor.capture(), restaurantRowMapperArgumentCaptor.capture(), customerIDCaptor.capture());
        Long customerIDArgument = customerIDCaptor.getValue();
        String sqlArgument =  sqlCaptor.getValue();

        //Then
        assertThat(sqlArgument).isEqualTo(sql);
        assertThat(customerIDArgument).isEqualTo(customer_ID);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void removeWishlistedRestaurantsByRestaurantID() {
        //Given
        String sql = """
        DELETE * FROM wishlists WHERE restaurant_ID = ?;        
        """;
        long customer_ID = 1;
        ArgumentCaptor<String> sqlCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Long> customerIDCaptor = ArgumentCaptor.forClass(Long.class);

        //When
        underTest.removeWishlistWithRestaurantID(customer_ID);
        Mockito.verify(jdbcTemplate).update( sqlCaptor.capture(),customerIDCaptor.capture());
        String sqlArgument =  sqlCaptor.getValue();
        Long customerIDArgument = customerIDCaptor.getValue();

        //Then
        assertThat(sqlArgument).isEqualTo(sql);
        assertThat(customerIDArgument).isEqualTo(customer_ID);

    }

    @Test
    public void removeWishlistedRestaurantsByCustomerID() {
        //Given
        String sql = "DELETE * FROM wishlists WHERE customer_ID = ?;";
        long restaurant_ID = 1;
        ArgumentCaptor<String> sqlCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Long> restaurantIDCaptor = ArgumentCaptor.forClass(Long.class);

        //When
        underTest.removeWishlistWithCustomerID(restaurant_ID);
        Mockito.verify(jdbcTemplate).update(sqlCaptor.capture(),restaurantIDCaptor.capture());
        String sqlArgument =  sqlCaptor.getValue();
        Long customerIDArgument = restaurantIDCaptor.getValue();

        //Then
        assertThat(sqlArgument).isEqualTo(sql);
        assertThat(customerIDArgument).isEqualTo(restaurant_ID);

    }

}