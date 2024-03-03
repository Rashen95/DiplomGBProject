package ru.geekbrains.DiplomGBProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.DiplomGBProject.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findRoleByName(String name);
}