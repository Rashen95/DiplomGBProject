package ru.geekbrains.DiplomGBProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.geekbrains.DiplomGBProject.dto.SignUpRequest;
import ru.geekbrains.DiplomGBProject.entity.User;
import ru.geekbrains.DiplomGBProject.repository.RoleRepository;
import ru.geekbrains.DiplomGBProject.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public Optional<User> findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User save(SignUpRequest signUpRequest) {
        User user = new User(signUpRequest.getUserName(),
                signUpRequest.getPassword(),
                signUpRequest.getFirstName(),
                signUpRequest.getLastName(),
                roleRepository.findRoleByName("ROLE_USER"));
        return userRepository.save(user);
    }

    public User getCurrentUser() {
        // Получение имени пользователя из контекста Spring Security
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return findUserByUserName(userName).get();
    }

    public boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }
}