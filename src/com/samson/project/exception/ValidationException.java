package com.samson.project.exception;

import com.samson.project.validator.Error;
import lombok.Getter;

import java.util.List;

public class ValidationException extends RuntimeException{
    @Getter
    private final List<Error> errors;

    public ValidationException(List<Error> errors){
        this.errors = errors;
    }
}
