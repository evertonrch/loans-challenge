package com.challenge.api.strategy.impl;

import com.challenge.api.dto.CustomerRequest;
import com.challenge.api.dto.LoanInfo;
import com.challenge.api.strategy.LoanStrategy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ConsignmentLoanStrategy implements LoanStrategy {

    private static final String TYPE = "CONSIGNMENT";
    private static final Short TAX = 2;
    private static final double LIMIT = 5000.0;

    @Override
    public Optional<LoanInfo> validate(CustomerRequest customerRequest) {
        double income = customerRequest.income().doubleValue();
        if (income >= LIMIT) {
            return Optional.of(new LoanInfo(TYPE, TAX));
        }

        return Optional.empty();
    }
}
