package dev.kukuh.CarsWebJava;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CarService {
    public List<Car> searchCars(Double length, Double weight, Double velocity, String color) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, 10, 1000, 200, "Red"));
        cars.add(new Car(2, 20, 2000, 300, "Blue"));
        cars.add(new Car(3, 30, 3000, 400, "Green"));
        return cars;
    }
}
