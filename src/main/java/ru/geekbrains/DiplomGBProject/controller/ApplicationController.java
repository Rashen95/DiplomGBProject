package ru.geekbrains.DiplomGBProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.DiplomGBProject.service.ApplicationService;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('USER')")
    public void create(@RequestParam("name") String name, @RequestParam("description") String description, @RequestHeader("Authorization") String authorization) {
        applicationService.save(name, description, authorization);
    }
}
