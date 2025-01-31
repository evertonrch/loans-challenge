package com.challenge.api.rule;

import org.springframework.stereotype.Component;

@Component
public class ValidateCustomerSalaryRule {

    public void validate(double income) {
       if (income <= 0.0) {
           throw new IllegalArgumentException("Valor não pode ser menor que zero.");
       }
    }
}
