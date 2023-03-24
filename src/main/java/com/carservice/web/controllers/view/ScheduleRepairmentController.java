package com.carservice.web.controllers.view;

import com.carservice.data.entities.User;
import com.carservice.data.entities.Vehicle;
import com.carservice.data.repositories.VehicleRepository;
import com.carservice.web.model.VehicleModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/schedule-repairment")
public class ScheduleRepairmentController {

    private final ModelMapper modelMapper;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public ScheduleRepairmentController(ModelMapper modelMapper, VehicleRepository vehicleRepository) {
        this.modelMapper = modelMapper;
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping
    public ModelAndView getScheduleRepairment() {
        VehicleModel vehicle = new VehicleModel();

        return new ModelAndView("/schedule-repairment", "vehicle", vehicle);
    }

    @PostMapping
    public String scheduleRepairment(HttpServletRequest request, @Valid @ModelAttribute("vehicle") VehicleModel vehicle, BindingResult result) {
        if (result.hasErrors()) {
            //that means validation didn't pass
            return "/schedule-repairment";
        }
        User user = (User) request.getSession().getAttribute("user");
        vehicle.setOwner(user);

        vehicleRepository.saveAndFlush(modelMapper.map(vehicle, Vehicle.class));

        return "redirect:/my-vehicles";
    }
}
