package com.samson.project.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDto {
    String first_name;
    String last_name;
    String patronymic;
    String gender;
    String birthday;
    String country;
    String passport;
    String email;
    String password;
    String role;
}
