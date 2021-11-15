CREATE TABLE reviews(
    id BIGSERIAL PRIMARY KEY,
    rating INT,
    reviewComment VARCHAR(255),
    restaurant_ID INT FOREIGN KEY REFERENCES restaurants(id),
    customer_ID INT FOREIGN KEY REFERENCES customers(id),)
)

CREATE TABLE wishlist(
wishlist_ID BIGSERIAL PRIMARY KEY,
restaurant_ID INT FOREIGN KEY REFERENCES restaurants(id),
customer_ID INT FOREIGN KEY REFERENCES customers(id)
)

INSERT INTO reviews(rating, reviewComment, restaurant_ID, customer_ID) VALUES( 5, "good service", 1, 1);
