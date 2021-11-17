CREATE TABLE reviews(
    review_ID BIGSERIAL PRIMARY KEY,
    rating INT,
    reviewComment VARCHAR(255),
    restaurant_ID INT REFERENCES restaurants(id),
    customer_ID INT REFERENCES customers(id)
);

CREATE TABLE wishlists(
    wishlist_ID BIGSERIAL PRIMARY KEY,
    restaurant_ID INT REFERENCES restaurants(id),
    customer_ID INT REFERENCES customers(id)
);

INSERT INTO reviews(rating, reviewComment, restaurant_ID, customer_ID) VALUES( 5, 'good service', 1, 1);

