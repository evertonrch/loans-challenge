package com.challenge.api.strategy;

import com.challenge.api.dto.CustomerRequest;
import com.challenge.api.dto.LoanInfo;

import java.util.Optional;

public interface LoanStrategy {

    Optional<LoanInfo> validate(CustomerRequest customerRequest);

}
