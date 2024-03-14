package ru.geekbrains.DiplomGBProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.geekbrains.DiplomGBProject.entity.Application;
import ru.geekbrains.DiplomGBProject.entity.User;
import ru.geekbrains.DiplomGBProject.repository.ApplicationRepository;

import java.time.LocalDateTime;
import java.util.List;

import static ru.geekbrains.DiplomGBProject.security.JwtAuthenticationFilter.BEARER_PREFIX;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final JwtService jwtService;

    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    public List<Application> findAllByUser(User user) {
        return applicationRepository.findAllByUser(user);
    }

    public void save(String name, String description, String authorization) {
        String jwt = authorization.substring(BEARER_PREFIX.length());
        String username = jwtService.extractUsername(jwt);
        System.out.println(username);
        System.out.println(name);
        System.out.println(description);
    }
}
