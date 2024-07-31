package com.samson.project.service;

import com.samson.project.dao.UserDao;
import com.samson.project.dto.CreateUserDto;
import com.samson.project.dto.UserDto;
import com.samson.project.exception.ValidationException;
import com.samson.project.mapper.CreateUserMapper;
import com.samson.project.mapper.UserMapper;
import com.samson.project.validator.CreateUserValidator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    public static final UserService INSTANCE = new UserService();
    private final CreateUserValidator createUserValidator =  CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();

    private final UserMapper userMapper = UserMapper.getInstance();

    public Optional<UserDto> login(String email, String password){
        return userDao.findByEmailAndPassword(email, password)
                .map(userMapper::mapFrom);
    }

    @SneakyThrows
    public Long create(CreateUserDto userDto){
        // 1 step - validation
        // 2 step - map
        // 3 step - userDao.save
        // 4 step - return id

        var validationResult = createUserValidator.isValid(userDto);
        if(!validationResult.isValid()){
            throw new ValidationException(validationResult.getErrors());
        }

        var userEntity = createUserMapper.mapFrom(userDto);
        userDao.save(userEntity);

        return userEntity.getId();
    }

    public static UserService getInstance(){
        return INSTANCE;
    }
}
