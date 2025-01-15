package com.challenge.api.rule;

import org.springframework.stereotype.Component;

@Component
public class ValidateCustomerAge {

    private static final int LIMIT = 30;

    public boolean validate(int age) {
        return age < LIMIT;
    }
}
