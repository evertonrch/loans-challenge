package com.challenge.api.rule;

import org.springframework.stereotype.Component;

@Component
public class ValidateCustomerSalary {

    private static final Double MIN_VALUE = 3000.0;
    private static final Double MAX_VALUE = 5000.0;

    public boolean validate(Double income) {
        return income >= MIN_VALUE && income <= MAX_VALUE;
    }

}
