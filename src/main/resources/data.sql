-- Create the `car` table
CREATE TABLE car (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    length DOUBLE NOT NULL,
    weight DOUBLE NOT NULL,
    velocity DOUBLE NOT NULL,
    color VARCHAR(50) NOT NULL
);

-- Insert sample data into the `car` table
INSERT INTO car (length, weight, velocity, color) VALUES (4.5, 1200, 180, 'red');
INSERT INTO car (length, weight, velocity, color) VALUES (4.2, 1100, 160, 'blue');
INSERT INTO car (length, weight, velocity, color) VALUES (4.7, 1400, 200, 'black');
