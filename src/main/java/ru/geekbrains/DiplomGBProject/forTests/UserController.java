package ru.geekbrains.DiplomGBProject.forTests;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/test")
    public HttpStatus test() {
        return HttpStatus.OK;
    }
}