package ru.geekbrains.DiplomGBProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpRequest {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
}
