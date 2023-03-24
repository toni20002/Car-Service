package com.carservice.web.controllers.view;

import com.carservice.data.entities.User;
import com.carservice.data.repositories.RoleMapper;
import com.carservice.data.repositories.UserRepository;
import com.carservice.data.repositories.VehicleRepository;
import com.carservice.web.model.UserModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@Slf4j
public class IndexController {
    private final RoleMapper roleMapper;
    private UserModel transitionalModel = new UserModel();
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public IndexController(RoleMapper roleMapper, BCryptPasswordEncoder bCryptPasswordEncoder,
                           UserRepository userRepository, ModelMapper modelMapper, VehicleRepository vehicleRepository) {
        this.roleMapper = roleMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping("/unauthorized")
    public String unauthorized() {
        return "/unauthorized";
    }

    @ModelAttribute("user")
    private void getModel(Model model) {
        model.addAttribute("user", transitionalModel);
    }

    @GetMapping("/")
    public String getIndex(HttpServletRequest request, Model model, Authentication authentication) {
        final String welcomeMessage = "Welcome to the Car Service System!";
        model.addAttribute("welcome", welcomeMessage);

        User user = (User) authentication.getPrincipal();
        request.getSession().setAttribute("user", user);
        return "index";
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "/login";
    }

    @GetMapping("/register")
    public ModelAndView getRegisterForm() {
        UserModel user = new UserModel();

        transitionalModel = user;
        return new ModelAndView("/register", "user", user);
    }

    @PostMapping("/register")
    public String submitRegister(@Valid @ModelAttribute("user") UserModel user,
                                 BindingResult result) {
        if (result.hasErrors()) {
            //that means validation didn't pass
            return "/register";
        }
        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setCreationTime(Timestamp.valueOf(LocalDateTime.now()));
            user.setRole_id(roleMapper.findRoleByAuthority("CUSTOMER"));

            userRepository.saveAndFlush(modelMapper.map(user, User.class));
            return "redirect:/login";

        } catch (Exception exception) {
            log.error(exception.getMessage());
            return "/register";

        }

    }

    @GetMapping("/my-vehicles")
    public String getMyVehicles(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");

        model.addAttribute("vehicles", vehicleRepository.getAllByOwner(user));

        return "/my-vehicles";
    }

}
