package dev.kukuh.CarsWebJava;

import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

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

    @GetMapping(value = "/download")
    public void downloadCarsAsXml(
            @RequestParam(required = false) Double length,
            @RequestParam(required = false) Double weight,
            @RequestParam(required = false) Double velocity,
            @RequestParam(required = false) String color,
            HttpServletResponse response) {

        // System.out
        //         .println("length: " + length + ", weight: " + weight + ", velocity: " + velocity + ", color: " + color);
        // List<Car> cars = carService.searchCars(length, weight, velocity, color);
        List<Car> cars = carRepository.searchCars(length, weight, velocity, color);
        System.out.println("cars: " + cars);
        response.setContentType("application/xml");
        response.setHeader("Content-Disposition", "attachment; filename=cars.xml");

        try {
            JAXBContext context = JAXBContext.newInstance(Car.class);
            // System.out.println("context: " + context);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // System.out.println("marshaller: " + marshaller);
            // StringWriter writer = new StringWriter();
            // for (Car car : cars) {
            // marshaller.marshal(car, writer);
            // }
            // System.out.println("writer: " + writer.toString());

            // Write XML to response output stream
            OutputStream outputStream = response.getOutputStream();
            for (Car car : cars) {
                // marshaller.marshal(car, writer);
                marshaller.marshal(car, outputStream);
            }
            outputStream.flush();

            // return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error converting to XML", e);
        }

        // return carService.convertCarsToXml(cars);
    }
}
