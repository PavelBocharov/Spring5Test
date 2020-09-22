package com.mar.spring.five.test.data.validator.handler;

import org.springframework.validation.MapBindingResult;
import org.springframework.validation.Validator;

import static java.util.Collections.EMPTY_MAP;

public abstract class AbstractValidationHandler<T, U extends Validator> {

    private final Class<T> validationClass;

    private final U validator;

    protected AbstractValidationHandler(Class<T> clazz, U validator) {
        this.validationClass = clazz;
        this.validator = validator;
    }

    public void isValid(T obj) {
        MapBindingResult errors = new MapBindingResult(EMPTY_MAP, obj.getClass().getSimpleName());
        validator.validate(obj, errors);
        if (!errors.getAllErrors().isEmpty()) {
            throw new RuntimeException(obj.getClass() + " is not valid. Errors: " + errors.getAllErrors());
        }
    }
}