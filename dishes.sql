-- Ensure the schema and table do not already exist
DROP TABLE IF EXISTS culinary.dishes;
DROP SCHEMA IF EXISTS culinary;

-- Create a new schema
CREATE SCHEMA culinary;
USE culinary;

-- Create the Dishes table within the culinary schema
CREATE TABLE culinary.dishes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    calories INT,
    vegetarian TINYINT(1) -- Representing boolean as TINYINT(1) for MySQL
);

-- Insert the dish records into the culinary.dishes table
INSERT INTO culinary.dishes (id, name, calories, vegetarian) VALUES
(1, 'Pizza calzone', 964, 1),
(2, 'Caesar Salad with Chicken', 260, 0),
(3, 'Apple Lattice Pie', 360, 1);
