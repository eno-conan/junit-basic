package com.junitbasic.demo.validator;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class EnumValidator implements ConstraintValidator<ValidEnum, String> {

    private final EnumChecker enumChecker;

    public EnumValidator(EnumChecker enumChecker) {
        this.enumChecker = enumChecker;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // nullは許容
        }
        return this.enumChecker.isValidKey(value);
    }
}


