package ru.geekbrains.DiplomGBProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.DiplomGBProject.dto.SignUpRequest;
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
        model.addAttribute("user", new SignUpRequest());
        return "registration";
    }

    @PostMapping()
    public String registerUser(@RequestParam("userName") String userName,
                               @RequestParam("password") String password,
                               @RequestParam("confirmPassword") String confirmPassword,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               Model model) {
        if (userService.existsByUserName(userName)) {
            model.addAttribute("user", SignUpRequest.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .build());
            model.addAttribute("userNameExists", true);
            model.addAttribute("existingUserName", userName);
            return "/registration";
        } else {
            userService.save(new SignUpRequest(userName, password, confirmPassword, firstName, lastName));
            System.out.printf("Пользователь %s с паролем %s зарегистрирован!%n", userName, password);
            return "login";
        }
    }
}