package ru.geekbrains.DiplomGBProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.DiplomGBProject.entity.Application;
import ru.geekbrains.DiplomGBProject.entity.User;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findAll();

    List<Application> findAllByUser(User user);
}
