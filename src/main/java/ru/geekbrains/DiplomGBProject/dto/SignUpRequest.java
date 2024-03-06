package ru.geekbrains.DiplomGBProject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SignUpRequest {
    private String userName;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
}