package ru.geekbrains.DiplomProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.DiplomProject.entity.User;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @GetMapping()
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping()
    public String registerUser(@RequestParam("userName") String userName,
                               @RequestParam("password") String password,
                               Model model) {
        System.out.printf("Пользователь %s с паролем %s зарегистрирован!%n", userName, password);
        return "redirect:/login";
    }
}
