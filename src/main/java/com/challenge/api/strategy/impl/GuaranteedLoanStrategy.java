package com.challenge.api.strategy.impl;

import com.challenge.api.dto.CustomerRequest;
import com.challenge.api.dto.LoanInfo;
import com.challenge.api.rule.ValidateCustomerAge;
import com.challenge.api.rule.ValidateCustomerLocation;
import com.challenge.api.rule.ValidateCustomerSalary;
import com.challenge.api.strategy.LoanStrategy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GuaranteedLoanStrategy implements LoanStrategy {

    private static final String TYPE = "GUARANTEED";
    private static final Short TAX = 3;

    private final ValidateCustomerSalary validateCustomerSalary;
    private final ValidateCustomerLocation validateCustomerLocation;
    private final ValidateCustomerAge validateCustomerAge;

    public GuaranteedLoanStrategy(ValidateCustomerSalary validateCustomerSalary,
                                  ValidateCustomerLocation validateCustomerLocation,
                                  ValidateCustomerAge validateCustomerAge) {

        this.validateCustomerSalary = validateCustomerSalary;
        this.validateCustomerLocation = validateCustomerLocation;
        this.validateCustomerAge = validateCustomerAge;
    }

    @Override
    public Optional<LoanInfo> validate(CustomerRequest customerRequest) {
        double income = customerRequest.income().doubleValue();
        if (validate(income, customerRequest.age(), customerRequest.location())) {
            return Optional.of(new LoanInfo(TYPE, TAX));
        }

        return Optional.empty();
    }

    private boolean validate(double income, int age, String location) {
        return (income <= 3000.0) || validateCustomerSalary.validate(income) || (validateCustomerAge.validate(age) && validateCustomerLocation.validate(location));
    }
}
