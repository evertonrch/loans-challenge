package com.challenge.api.rule;

import org.springframework.stereotype.Component;

@Component
public class PersonalAndGuaranteedRule {

    private static final double INITIAL_LIMIT = 3000.0;
    private static final double FINAL_LIMIT = 5000.0;
    private static final int AGE_LIMIT = 30;
    private static final String VALID_LOCATION = "SP";

    private final ValidateCustomerSalaryRule validateCustomerSalaryRule;
    private final ValidateCustomerAgeRule validateCustomerAgeRule;
    private final ValidateCustomerLocationRule validateCustomerLocationRule;

    public PersonalAndGuaranteedRule(ValidateCustomerSalaryRule validateCustomerSalaryRule, ValidateCustomerAgeRule validateCustomerAgeRule, ValidateCustomerLocationRule validateCustomerLocationRule) {
        this.validateCustomerSalaryRule = validateCustomerSalaryRule;
        this.validateCustomerAgeRule = validateCustomerAgeRule;
        this.validateCustomerLocationRule = validateCustomerLocationRule;
    }

    public boolean validate(double income, int age, String location) {
        validateCustomerSalaryRule.validate(income);
        validateCustomerAgeRule.validate(age);
        validateCustomerLocationRule.validate(location);

        return isValid(income, age, location);
    }

    private boolean isValid(double income, int age, String location) {
        return (income > INITIAL_LIMIT && income < FINAL_LIMIT) && age < AGE_LIMIT && VALID_LOCATION.equals(location);
    }
}
