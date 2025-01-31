package com.challenge.api.rule;

import org.springframework.stereotype.Component;

@Component
public class ValidateCustomerLocationRule {

    public void validate(String location) {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("O local estã inválido.");
        }
    }
}
