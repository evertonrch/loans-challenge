package com.challenge.api.strategy.impl;

import com.challenge.api.dto.CustomerRequest;
import com.challenge.api.dto.LoanInfo;
import com.challenge.api.rule.PersonalAndGuaranteedRule;
import com.challenge.api.strategy.LoanStrategy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GuaranteedLoanStrategy implements LoanStrategy {

    private static final String TYPE = "GUARANTEED";
    private static final Short TAX = 3;
    private static final double LIMIT = 3000.0;

    private final PersonalAndGuaranteedRule personalAndGuaranteedRule;

    public GuaranteedLoanStrategy(PersonalAndGuaranteedRule personalAndGuaranteedRule) {
        this.personalAndGuaranteedRule = personalAndGuaranteedRule;
    }

    @Override
    public Optional<LoanInfo> validate(CustomerRequest customerRequest) {
        double income = customerRequest.income().doubleValue();
        int age = customerRequest.age();
        String location = customerRequest.location();

        if (income <= LIMIT || personalAndGuaranteedRule.validate(income, age, location)) {
            return Optional.of(new LoanInfo(TYPE, TAX));
        }

        return Optional.empty();
    }
}
