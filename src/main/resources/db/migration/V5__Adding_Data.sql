INSERT INTO restaurants(restaurantName, cuisine, restaurantAddress, vegetarian, halal, glutenFree, price,
 averageRating) VALUES ('Mak Grillz', 'American', '401 Hoe St', FALSE, TRUE, FALSE, 2, 4.3);
INSERT INTO restaurants(restaurantName, cuisine, restaurantAddress, vegetarian, halal, glutenFree, price,
  averageRating) VALUES ('Cote', 'French', '57 Whitecross St', TRUE, TRUE, TRUE, 2, 4.1);
INSERT INTO restaurants(restaurantName, cuisine, restaurantAddress, vegetarian, halal, glutenFree, price,
  averageRating) VALUES ('Marugame', 'Japanese', '114 Middlesex St', TRUE, FALSE, TRUE, 2, 4.2);
INSERT INTO restaurants(restaurantName, cuisine, restaurantAddress, vegetarian, halal, glutenFree, price,
   averageRating) VALUES ('Seoul Bakery', 'Korean', '57 Whitecross St', TRUE, TRUE, FALSE, 1, 4.4);
INSERT INTO restaurants(restaurantName, cuisine, restaurantAddress, vegetarian, halal, glutenFree, price,
   averageRating) VALUES ('Misato', 'Japanese', '11 Wardour St', TRUE, TRUE, TRUE, 1, 4.4);
INSERT INTO restaurants(restaurantName, cuisine, restaurantAddress, vegetarian, halal, glutenFree, price,
   averageRating) VALUES ('Franco Manco', 'Italian', '51 Berwick St', TRUE, TRUE, TRUE, 1, 4.0);

INSERT INTO reviews(rating, reviewComment, restaurant_ID, customer_ID) VALUES(5, 'Excellent food', 2, 1);
INSERT INTO reviews(rating, reviewComment, restaurant_ID, customer_ID) VALUES(3, 'Nothing too special', 3, 1);
INSERT INTO reviews(rating, reviewComment, restaurant_ID, customer_ID) VALUES(2, 'Below average', 4, 1);
INSERT INTO reviews(rating, reviewComment, restaurant_ID, customer_ID) VALUES(5, 'Sensational food', 5, 1);
INSERT INTO reviews(rating, reviewComment, restaurant_ID, customer_ID) VALUES(1, 'Never again', 6, 1);
INSERT INTO reviews(rating, reviewComment, restaurant_ID, customer_ID) VALUES(4, 'Good quality food', 7, 1);
INSERT INTO reviews(rating, reviewComment, restaurant_ID, customer_ID) VALUES(5, 'Spectacular', 8, 1);
INSERT INTO reviews(rating, reviewComment, restaurant_ID, customer_ID) VALUES(1, 'Do not bother', 9, 1);

INSERT INTO wishlists(restaurant_ID, customer_ID) VALUES(11, 1);
INSERT INTO wishlists(restaurant_ID, customer_ID) VALUES(12, 1);
INSERT INTO wishlists(restaurant_ID, customer_ID) VALUES(13, 1);