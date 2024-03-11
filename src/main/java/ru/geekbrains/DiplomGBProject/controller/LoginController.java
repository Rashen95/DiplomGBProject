package ru.geekbrains.DiplomGBProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.DiplomGBProject.dto.SignInRequest;
import ru.geekbrains.DiplomGBProject.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping()
    public String getLoginPage(Model model) {
        model.addAttribute("userLogin", new SignInRequest());
        return "login";
    }

    @PostMapping("/log")
    public String loginUser(@RequestParam("userName") String userName,
                            @RequestParam("password") String password,
                            Model model) {
        if (userService.existsByUserName(userName)
                && userService.findUserByUserName(userName).get().getPassword().equals(passwordEncoder.encode(password))) {
            System.out.println("ЧЕТКО");
        } else {
            System.out.println("Такого пользователя нет");
        }
        return "redirect:login";
    }
}