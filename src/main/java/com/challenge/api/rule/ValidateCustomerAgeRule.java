package com.challenge.api.rule;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ValidateCustomerAgeRule {

    private static final int ZERO = 0;

    public void validate(Integer age) {
        if (Objects.isNull(age) || age <= 0) {
            throw new IllegalArgumentException("Idade está inválida.");
        }
    }
}
