package com.challenge.api.enums;

public enum InterestRate {

    PERSONAL(0.4),
    GUARANTEED(0.3),
    CONSIGNMENT(0.2);

    private final Double tax;

    InterestRate(Double tax) {
        this.tax = tax;
    }

    public Double getTax() {
        return tax;
    }
}
