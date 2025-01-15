package com.challenge.api.dto;

import java.math.BigDecimal;

public record CustomerRequest(
        Integer age,
        String cpf,
        String name,
        BigDecimal income,
        String location
) {}
