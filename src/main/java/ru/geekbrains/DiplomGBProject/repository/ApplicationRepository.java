package ru.geekbrains.DiplomGBProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.DiplomGBProject.entity.Application;
import ru.geekbrains.DiplomGBProject.entity.Status;
import ru.geekbrains.DiplomGBProject.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    public List<Application> getAll();

    public List<Application> getAllByStatus(Status status);

    public List<Application> getAllByUser(User user);

    public List<Application> getAllByUserAndStatus(User user, Status status);
}
