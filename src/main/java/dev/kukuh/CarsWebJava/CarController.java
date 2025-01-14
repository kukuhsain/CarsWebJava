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
    @Autowired
    private CarRepository carRepository;

    @GetMapping("/")
    public String showCars(
            @RequestParam(required = false) Double length,
            @RequestParam(required = false) Double weight,
            @RequestParam(required = false) Double velocity,
            @RequestParam(required = false) String color,
            Model model) {
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
        List<Car> cars = carRepository.searchCars(length, weight, velocity, color);
        response.setContentType("application/xml");
        response.setHeader("Content-Disposition", "attachment; filename=cars.xml");

        try {
            JAXBContext context = JAXBContext.newInstance(CarListWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            CarListWrapper wrapper = new CarListWrapper();
            wrapper.setCars(cars);

            // Write XML to response output stream
            OutputStream outputStream = response.getOutputStream();
            marshaller.marshal(wrapper, outputStream);
            outputStream.flush();
        } catch (Exception e) {
            throw new RuntimeException("Error converting to XML", e);
        }
    }
}
