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
INSERT INTO car (length, weight, velocity, color) VALUES (4.6, 1300, 170, 'white');
INSERT INTO car (length, weight, velocity, color) VALUES (5.0, 1500, 190, 'gray');
INSERT INTO car (length, weight, velocity, color) VALUES (4.3, 1150, 175, 'green');
INSERT INTO car (length, weight, velocity, color) VALUES (4.8, 1250, 180, 'yellow');
INSERT INTO car (length, weight, velocity, color) VALUES (4.4, 1100, 165, 'orange');
INSERT INTO car (length, weight, velocity, color) VALUES (5.1, 1600, 210, 'purple');
INSERT INTO car (length, weight, velocity, color) VALUES (4.9, 1350, 185, 'brown');
INSERT INTO car (length, weight, velocity, color) VALUES (4.5, 1200, 160, 'pink');
INSERT INTO car (length, weight, velocity, color) VALUES (4.7, 1400, 195, 'silver');
INSERT INTO car (length, weight, velocity, color) VALUES (4.3, 1250, 170, 'beige');
INSERT INTO car (length, weight, velocity, color) VALUES (4.6, 1300, 180, 'teal');
INSERT INTO car (length, weight, velocity, color) VALUES (5.2, 1550, 205, 'maroon');
INSERT INTO car (length, weight, velocity, color) VALUES (4.8, 1350, 190, 'lime');
INSERT INTO car (length, weight, velocity, color) VALUES (5.0, 1400, 195, 'turquoise');
INSERT INTO car (length, weight, velocity, color) VALUES (4.4, 1200, 165, 'violet');
INSERT INTO car (length, weight, velocity, color) VALUES (4.9, 1450, 200, 'gold');
INSERT INTO car (length, weight, velocity, color) VALUES (4.7, 1300, 185, 'indigo');
