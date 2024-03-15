package ru.geekbrains.DiplomGBProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.DiplomGBProject.entity.Application;
import ru.geekbrains.DiplomGBProject.entity.Status;
import ru.geekbrains.DiplomGBProject.service.ApplicationService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public void create(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestHeader("Authorization") String authorization) {
        applicationService.save(name, description, authorization);
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Application> listApplication() {
        return applicationService.getAll();
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Application> listApplicationByStatus(@RequestParam("status") String status) {
        if (Status.NOT_STARTED.toString().equalsIgnoreCase(status)) {
            return applicationService.getAllByStatus(Status.NOT_STARTED);
        } else if (Status.IN_PROGRESS.toString().equalsIgnoreCase(status)) {
            return applicationService.getAllByStatus(Status.IN_PROGRESS);
        } else if (Status.COMPLETE.toString().equalsIgnoreCase(status)) {
            return applicationService.getAllByStatus(Status.COMPLETE);
        } else {
            return new ArrayList<>();
        }
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<Application> listApplicationByUser(@RequestHeader("Authorization") String authorization) {
        return applicationService.getAllByUser(authorization);
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<Application> listApplicationByUserAndStatus(
            @RequestHeader("Authorization") String authorization,
            @RequestParam("status") String status) {
        Status.valueOf(status)

        return applicationService.getAllByUser(authorization);
    }
}
