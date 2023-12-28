-- Create Address Table
CREATE TABLE IF NOT EXISTS address (
id SERIAL PRIMARY KEY,
zip_code INT,
city VARCHAR(255),
address VARCHAR(255),
create_stamp TIMESTAMP
);


-- Create Supplier Table
CREATE TABLE IF NOT EXISTS supplier (
id SERIAL PRIMARY KEY,
name VARCHAR(255),
address_id INT,
active BOOLEAN,
create_stamp TIMESTAMP,
FOREIGN KEY (address_id) REFERENCES address(id)
);