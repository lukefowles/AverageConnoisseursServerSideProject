CREATE TABLE restaurants (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    restaurantName VARCHAR(255) NOT NULL,
    cuisine VARCHAR(255) NOT NULL,
    restaurantAddress VARCHAR(255) NOT NULL,
    vegetarian BOOLEAN,
    halal BOOLEAN,
    glutenFree BOOLEAN,
    price INT,
    averageRating FlOAT
);

INSERT INTO customers(customerName, email, mobileNumber) VALUES('Luke', 'luke@lukemail.com', 0800001066);
INSERT INTO customers(customerName, email, mobileNumber) VALUES('Jess', 'jess@lukemail.com', 0899001066);
INSERT INTO customers(customerName, email, mobileNumber) VALUES('Yonis', 'yonis@lukemail.com', 0800701076);
INSERT INTO customers(customerName, email, mobileNumber) VALUES('Aaishah', 'aaishah@lukemail.com', 0800001066);

INSERT INTO restaurants(restaurantName, cuisine, restaurantAddress, vegetarian, halal, glutenFree, price,
 averageRating) VALUES ('Greggs', 'Bakery', '1 Greggs Avenue', FALSE, FALSE, FALSE, 1, 5.0);
INSERT INTO restaurants(restaurantName, cuisine, restaurantAddress, vegetarian, halal, glutenFree, price,
 averageRating) VALUES ('Mono Wraps', 'Kebab', '234 Holloway Road', FALSE, TRUE, FALSE, 1, 5.0);
INSERT INTO restaurants(restaurantName, cuisine, restaurantAddress, vegetarian, halal, glutenFree, price
 , averageRating) VALUES ('Xiian Impressions', 'Chinese', '12 Benwell Road', TRUE, FALSE, FALSE, 1, 4.4);
INSERT INTO restaurants(restaurantName, cuisine, restaurantAddress, vegetarian, halal, glutenFree, price,
  averageRating) VALUES ('Hare & Tortoise', 'Japanese', 'Brunswick Centre', FALSE, TRUE, FALSE, 2, 4.5);
INSERT INTO restaurants(restaurantName, cuisine, restaurantAddress, vegetarian, halal, glutenFree, price,
   averageRating) VALUES ('Morleys Chicken Shop', 'Chicken', 'Sothwark Park Road', FALSE, FALSE, FALSE, 1, 3.7);
INSERT INTO restaurants(restaurantName, cuisine, restaurantAddress, vegetarian, halal, glutenFree, price,
     averageRating) VALUES ('Burgeri', 'Hamburger', 'Great Marlborough Street', TRUE, TRUE, FALSE, 2, 4.0);
INSERT INTO restaurants(restaurantName, cuisine, restaurantAddress, vegetarian, halal, glutenFree, price,
     averageRating) VALUES ('Saffron Kitchen', 'Indian', '300 Lea Bridge Road', TRUE, TRUE, FALSE, 2, 3.9);
INSERT INTO restaurants(restaurantName, cuisine, restaurantAddress, vegetarian, halal, glutenFree, price,
 averageRating) VALUES ('Sticks n Sushi', 'Japanese', '12 Crossrail PI', FALSE, FALSE, FALSE, 3, 5.0);

