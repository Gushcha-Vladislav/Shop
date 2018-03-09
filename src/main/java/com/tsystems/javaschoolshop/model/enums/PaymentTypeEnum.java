package com.tsystems.javaschoolshop.model.enums;

public enum PaymentTypeEnum {

    CASH("Cash"),

    CREDIT("Credit card");

    private final String name;

    PaymentTypeEnum(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

