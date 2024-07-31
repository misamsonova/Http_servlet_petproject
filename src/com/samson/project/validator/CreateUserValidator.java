package com.samson.project.validator;

import com.samson.project.dto.CreateUserDto;
import com.samson.project.entity.Gender;
import com.samson.project.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto>{
    public static final CreateUserValidator INSTANCE = new CreateUserValidator();
    @Override
    public ValidationResult isValid(CreateUserDto object) {
        var validationResult = new ValidationResult();

        if(!LocalDateFormatter.isValid(object.getBirthday())){
            validationResult.add(Error.of("invalid.birthday","Birthday is invalid"));
        }

        if(object.getGender() == null || Gender.valueOf(object.getGender()) == null){
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }

        if(object.getFirst_name() == null){
            validationResult.add(Error.of("invalid.first_name", "First name not entered"));
        }
        if(object.getLast_name() == null){
            validationResult.add(Error.of("invalid.last_name", "Last name not entered"));
        }

        //Длина цифр паспорта
        if(object.getPassport() == null ){
            validationResult.add(Error.of("invalid.passport", "Passport data is not entered"));
        }

        if(object.getCountry() == null){
            validationResult.add(Error.of("invalid.country", "Country is not entered"));
        }

        return validationResult;
    }

    public static CreateUserValidator getInstance(){
        return INSTANCE;
    }
}


