package com.samson.project.mapper;

import com.samson.project.dto.CreateUserDto;
import com.samson.project.entity.Gender;
import com.samson.project.entity.Role;
import com.samson.project.entity.User;
import com.samson.project.util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, User>{
//    public static final String IMAGE_FOLDER="users/";
    public static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .first_name(object.getFirst_name())
                .last_name(object.getLast_name())
                .patronymic(object.getPatronymic())
                .gender(Gender.valueOf(object.getGender()))
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .country(object.getCountry())
                .passport(Long.valueOf(object.getPassport()))
                .email(object.getEmail())
                .password(object.getPassword())
                .role(Role.valueOf(object.getRole()))
                .build();
    }

    public static CreateUserMapper getInstance(){
        return INSTANCE;
    }
}
