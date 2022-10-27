package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.service.CarService;


@Controller
public class CarsController {

    private CarService carService;

    @GetMapping(value = "/cars")
    public String printWelcomeCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        if (carService.getAll().size() < count) {
            count = carService.getAll().size();
        }
        model.addAttribute("messages", carService.getFirst(count));
        return "cars";
    }


    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }
}
