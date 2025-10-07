package com.eatexpress.app.order.domain;

public enum PaymentStatus {
    PENDING("Pending"),
    AUTHORIZED("Authorized"),
    CAPTURED("Captured"),
    FAILED("Failed"),
    REFUNDED("Refunded");

    private final String displayName;

    PaymentStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isFinal() {
        return this == CAPTURED || this == FAILED || this == REFUNDED;
    }

    public boolean isCompletedSuccessfully() {
        return this == CAPTURED;
    }
}
