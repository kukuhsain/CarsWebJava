package dev.kukuh.CarsWebJava;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CarRepository {
    private final JdbcTemplate jdbcTemplate;

    public CarRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Car> rowMapper = (rs, rowNum) -> {
        return new Car(
                rs.getLong("id"),
                rs.getDouble("length"),
                rs.getDouble("weight"),
                rs.getDouble("velocity"),
                rs.getString("color"));
    };

    public List<Car> searchCars(Double length, Double weight, Double velocity, String color) {
        String sql = "SELECT * FROM car WHERE 1=1";

        if (length != null)
            sql += " AND length = ?";
        if (weight != null)
            sql += " AND weight = ?";
        if (velocity != null)
            sql += " AND velocity = ?";
        if (color != null)
            sql += " AND color LIKE ?";

        return jdbcTemplate.query(sql, rowMapper);
    }
}
