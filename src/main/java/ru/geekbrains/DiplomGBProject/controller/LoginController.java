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
import ru.geekbrains.DiplomGBProject.service.AuthenticationService;
import ru.geekbrains.DiplomGBProject.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService authenticationService;

    @GetMapping()
    public String getLoginPage(Model model) {
        model.addAttribute("userLogin", new SignInRequest());
        return "login";
    }

    @PostMapping("/log")
    public String loginUser(@RequestParam("userName") String userName,
                            @RequestParam("password") String password,
                            Model model) {
        if (userService.findByUserName(userName).isPresent()
                && passwordEncoder.matches(password, userService.getByUserName(userName).getPassword())) {
            model.addAttribute("message",
                    authenticationService.signIn(
                                    SignInRequest.builder()
                                            .userName(userName)
                                            .password(password)
                                            .build())
                            .getToken());
            return "token";
        } else {
            return "redirect:login";
        }
    }
}