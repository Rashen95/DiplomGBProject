package ru.geekbrains.DiplomGBProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/check")
    public String admin() {
        System.out.println(123);
        return "ЧЕТКО";
    }
}