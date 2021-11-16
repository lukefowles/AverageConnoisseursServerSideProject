CREATE TABLE customers (
    id BIGSERIAL PRIMARY KEY,
    customerName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    mobileNumber int NOT NULL
)
