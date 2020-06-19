package com.example.blog.controllers;

import com.example.blog.models.request.UserCreateRequest;
import com.example.blog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @author smustafov
 */
@Controller
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String loadRegisterPage(Model model) {
        model.addAttribute("userCreateRequest", new UserCreateRequest());
        return "signup";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserCreateRequest userCreateRequest, Errors errors) {
        if (errors.hasErrors()) {
            return "signup";
        }

        userService.create(userCreateRequest);

        return "redirect:/";
    }

}
