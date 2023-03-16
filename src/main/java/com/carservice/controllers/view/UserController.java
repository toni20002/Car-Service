package com.carservice.controllers.view;

import com.carservice.data.User;
import com.carservice.data.mappers.UserMapper;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserMapper userMapper;
    private User transitionalModel = new User();

    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @ModelAttribute("user")
    private void getModel(Model model) {
        model.addAttribute("user", transitionalModel);
    }

    @GetMapping("/register")
    public ModelAndView getRegisterForm(User user) {
        user.setCreationTime(Timestamp.valueOf(LocalDateTime.now()));
        user.setRole("admin");

        transitionalModel = user;
        return new ModelAndView("/user/register.html", "user", user);
    }

    @PostMapping("/register")
    public String submitRegister(@Valid @ModelAttribute User user,
                                 BindingResult result) {
        if (result.hasErrors()) {
            //that means validation didn't pass
            return "/user/register.html";
        }
        try {
            if (userMapper.registerUser(user)) {
                //TODO we need to create logic to login our user after registration
                return "/";
            }
        } catch (Exception exception) {
            log.error(exception.getMessage());
            return "/user/register.html";

        }

        return "redirect:/";
    }

    //TODO login
}
