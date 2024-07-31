package com.samson.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    Long id;
    String first_name;
    String last_name;
    String patronymic;

    Gender gender;
    LocalDate birthday;
    String country;
    Long passport;
    String email;
    String password;
    Role role;
}
