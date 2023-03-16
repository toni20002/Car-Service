package com.carservice.controllers.view;

import com.carservice.data.CarService;
import com.carservice.data.mappers.CarServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/car-services")
public class CarServiceController {

    private final CarServiceMapper carServiceMapper;

    @Autowired
    public CarServiceController(CarServiceMapper carServiceMapper) {
        this.carServiceMapper = carServiceMapper;
    }

    @GetMapping
    public String getCarServices(Model model) {
        final List<CarService> carServiceList = carServiceMapper.getAll();
        model.addAttribute("carServices", carServiceList);
        return "/car-services.html";
    }
}
