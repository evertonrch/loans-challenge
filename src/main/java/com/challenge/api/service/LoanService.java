package com.challenge.api.service;

import com.challenge.api.dto.CustomerRequest;
import com.challenge.api.dto.LoanInfo;
import com.challenge.api.dto.LoanResponse;
import com.challenge.api.strategy.LoanStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    private final List<LoanStrategy> strategies;

    public LoanService(List<LoanStrategy> strategies) {
        this.strategies = strategies;
    }


    public LoanResponse getAvailableLoans(CustomerRequest customerRequest) {
        List<LoanInfo> loans = strategies.stream()
                .map(strategy -> strategy.validate(customerRequest))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        return new LoanResponse(customerRequest.name(), loans);
    }

}
