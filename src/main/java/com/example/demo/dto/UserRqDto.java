package com.example.demo.dto;

import com.example.demo.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRqDto {
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Long passport;
    private String password;
}
