DROP TABLE IF EXISTS products;

CREATE TABLE products (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  price NUMERIC(8,2) NOT NULL,
  url VARCHAR(255) NOT NULL
);