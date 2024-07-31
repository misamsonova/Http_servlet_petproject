package com.samson.project.mapper;

import com.samson.project.dto.UserDto;
import com.samson.project.entity.User;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor( access = PRIVATE)
public class UserMapper implements Mapper<User,UserDto>{

    private static final UserMapper INSTANCE = new UserMapper();
    @Override
    public UserDto mapFrom(User object) {
        return UserDto.builder()
                .first_name(object.getFirst_name())
                .last_name(object.getLast_name())
                .patronymic(object.getPatronymic())
                .gender(object.getGender())
                .birthday(object.getBirthday())
                .country(object.getCountry())
                .passport(object.getPassport())
                .email(object.getEmail())
                .password(object.getPassword())
                .role(object.getRole())
                .build();
    }

    public static UserMapper getInstance() {
        return INSTANCE;
    }
}
