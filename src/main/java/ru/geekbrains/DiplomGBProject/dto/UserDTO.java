package ru.geekbrains.DiplomGBProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
}