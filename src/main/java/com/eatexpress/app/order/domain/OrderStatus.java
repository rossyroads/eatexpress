package com.eatexpress.app.order.domain;

public enum OrderStatus {
    PLACED("Placed"),
    ACCEPTED("Accepted"),
    READY_FOR_PICKUP("Ready for pickup"),
    DELIVERED("Delivered");

    private final String displayName;

    OrderStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isFinished() {
        return this == DELIVERED;
    }

    public boolean isInProgress() {
        return this == ACCEPTED || this == READY_FOR_PICKUP;
    }
}
