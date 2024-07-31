package com.samson.project.dto;

import com.samson.project.entity.Gender;
import com.samson.project.entity.Role;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class UserDto {
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