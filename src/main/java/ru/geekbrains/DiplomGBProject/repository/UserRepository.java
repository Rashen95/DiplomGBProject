package ru.geekbrains.DiplomGBProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.DiplomGBProject.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUserName(String username);
    public boolean existsByUserName(String userName);
}