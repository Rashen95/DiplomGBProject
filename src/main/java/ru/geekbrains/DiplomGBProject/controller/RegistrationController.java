package ru.geekbrains.DiplomGBProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.DiplomGBProject.dto.UserDTO;
import ru.geekbrains.DiplomGBProject.service.JwtService;
import ru.geekbrains.DiplomGBProject.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {
    private final UserService userService;
    private final JwtService jwtService;

    @GetMapping()
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "registration";
    }

    @PostMapping()
    public String registerUser(@RequestParam("userName") String userName,
                               @RequestParam("password") String password,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               Model model) {
        if (userService.findUserByUserName(userName).isPresent()) {
            System.out.printf("Пользователь %s уже создан", userName);
        } else {
            userService.save(new UserDTO(userName, password, firstName, lastName));
            System.out.printf("Пользователь %s с паролем %s зарегистрирован!%n", userName, password);
        }
        System.out.println(jwtService.generateToken(userService.findUserByUserName(userName).get()));
        return "redirect:/login";
    }
}