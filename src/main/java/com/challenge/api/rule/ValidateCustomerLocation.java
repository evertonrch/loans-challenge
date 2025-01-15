package com.challenge.api.rule;

import org.springframework.stereotype.Component;

@Component
public class ValidateCustomerLocation {

    private static final String SAO_PAULO = "SP";

    public boolean validate(String location) {
        return SAO_PAULO.equals(location);
    }
}
