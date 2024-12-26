package dev.kukuh.CarsWebJava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(CarRepository.class) // Include CarRepository in the test context
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private DataSource dataSource;

    @BeforeEach
    void setup() throws Exception {
        // Initialize the database schema and sample data
        try (var connection = dataSource.getConnection();
                var statement = connection.createStatement()) {

            // Create the table
            // statement.executeUpdate("""
            //             CREATE TABLE car (
            //                 id BIGINT AUTO_INCREMENT PRIMARY KEY,
            //                 length DOUBLE NOT NULL,
            //                 weight DOUBLE NOT NULL,
            //                 velocity DOUBLE NOT NULL,
            //                 color VARCHAR(50) NOT NULL
            //             );
            //         """);

            // Insert sample data
            // statement.executeUpdate("""
            //             INSERT INTO car (length, weight, velocity, color)
            //             VALUES (4.5, 1200, 180, 'red');
            //         """);
            // statement.executeUpdate("""
            //             INSERT INTO car (length, weight, velocity, color)
            //             VALUES (4.2, 1100, 160, 'blue');
            //         """);
        }
    }

    @Test
    void testSearchCars_withMatchingCriteria() {
        // Act
        List<Car> results = carRepository.searchCars(4.5, 1200.0, 180.0, "red");

        // Assert
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getColor()).isEqualTo("red");
    }

    @Test
    void testSearchCars_withNoMatchingCriteria() {
        // Act
        List<Car> results = carRepository.searchCars(5.0, 1500.0, 200.0, "green");

        // Assert
        assertThat(results).isEmpty();
    }

    @Test
    void testSearchCars_withPartialCriteria() {
        // Act
        List<Car> results = carRepository.searchCars(null, 1200.0, null, null);

        // Assert
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getColor()).isEqualTo("red");
    }
}
