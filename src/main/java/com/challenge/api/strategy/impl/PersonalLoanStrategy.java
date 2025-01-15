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
public class PersonalLoanStrategy implements LoanStrategy {

    private static final String TYPE = "PERSONAL";
    private static final Short TAX = 4;

    private final ValidateCustomerSalary validateCustomerSalary;
    private final ValidateCustomerAge validateCustomerAge;
    private final ValidateCustomerLocation validateCustomerLocation;

    public PersonalLoanStrategy(ValidateCustomerSalary validateCustomerSalary,
                                ValidateCustomerAge validateCustomerAge,
                                ValidateCustomerLocation validateCustomerLocation) {

        this.validateCustomerSalary = validateCustomerSalary;
        this.validateCustomerAge = validateCustomerAge;
        this.validateCustomerLocation = validateCustomerLocation;
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
