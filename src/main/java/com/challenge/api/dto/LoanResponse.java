package com.challenge.api.dto;

import java.util.List;

public record LoanResponse(
        String customer,
        List<LoanInfo> loans
) {}














