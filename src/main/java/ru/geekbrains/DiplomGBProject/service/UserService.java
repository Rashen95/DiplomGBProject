package ru.geekbrains.DiplomGBProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    public Optional<User> findUserByUserName(String userName) {
        // Обязательно преобразуем логин к маленьким буквам
        return userRepository.findByUserName(userName.toLowerCase());
    }

    public void save(SignUpRequest signUpRequest) {
        // Преобразование имени и фамилии к классическому варианту с большой буквы
        String firstName = signUpRequest.getFirstName();
        firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        String lastName = signUpRequest.getLastName();
        lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();

        User user = new User(
                // логин всегда маленькими буквами
                signUpRequest.getUserName().toLowerCase(),
                passwordEncoder.encode(signUpRequest.getPassword()),
                firstName,
                lastName,
                roleRepository.findRoleByName("ROLE_USER"));
        userRepository.save(user);
    }

    public boolean existsByUserName(String userName) {
        // Обязательно преобразуем логин к маленьким буквам
        return userRepository.existsByUserName(userName.toLowerCase());
    }
}