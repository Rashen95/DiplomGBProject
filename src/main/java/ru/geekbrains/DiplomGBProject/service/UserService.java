package ru.geekbrains.DiplomGBProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.geekbrains.DiplomGBProject.entity.User;
import ru.geekbrains.DiplomGBProject.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username.toLowerCase())
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }

    public Optional<User> findByUserName(String username) {
        return userRepository.findByUsername(username.toLowerCase());
    }

    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }
}