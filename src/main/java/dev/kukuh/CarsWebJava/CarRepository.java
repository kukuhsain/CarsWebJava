package dev.kukuh.CarsWebJava;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
        StringBuilder sql = new StringBuilder("SELECT * FROM car WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (length != null) {
            sql.append(" AND length = ?");
            params.add(length);
        }
        if (weight != null) {
            sql.append(" AND weight = ?");
            params.add(weight);
        }
        if (velocity != null) {
            sql.append(" AND velocity = ?");
            params.add(velocity);
        }
        if (color != null && !color.isEmpty()) {
            sql.append(" AND color = ?");
            params.add(color);
        }

        return jdbcTemplate.query(sql.toString(), rowMapper, params.toArray());
    }
}
