DROP TABLE IF EXISTS categories CASCADE;

CREATE TABLE categories (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE products (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  price NUMERIC(8,2) NOT NULL,
  url VARCHAR(255) NOT NULL,
  category_id INTEGER REFERENCES categories(id)
);

