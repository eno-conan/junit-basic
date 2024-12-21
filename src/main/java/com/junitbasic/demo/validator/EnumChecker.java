package com.junitbasic.demo.validator;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class EnumChecker {

    public boolean isValidKey(String key) {
        for (ExampleEnum e : ExampleEnum.values()) {
            if (e.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    } 
}
