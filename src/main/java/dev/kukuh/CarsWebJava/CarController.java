package dev.kukuh.CarsWebJava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    // @Autowired
    // private CarService carService;

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/")
    public String showCars(
            @RequestParam(required = false) Double length,
            @RequestParam(required = false) Double weight,
            @RequestParam(required = false) Double velocity,
            @RequestParam(required = false) String color,
            Model model) {
        // List<Car> cars = carService.searchCars(length, weight, velocity, color);
        List<Car> cars = carRepository.searchCars(length, weight, velocity, color);

        model.addAttribute("cars", cars);
        model.addAttribute("length", length);
        model.addAttribute("weight", weight);
        model.addAttribute("velocity", velocity);
        model.addAttribute("color", color);
        
        return "index";
    }
}
