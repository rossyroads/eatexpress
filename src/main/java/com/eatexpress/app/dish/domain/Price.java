package com.eatexpress.app.dish.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Price {

    private BigDecimal amount;

    public Price(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Price amount cannot be null.");
        }

        final BigDecimal MAX_PRICE = new BigDecimal("9999.99");

        // Validation for maximum allowed price
        if (amount.compareTo(MAX_PRICE) > 0) {
            throw new IllegalArgumentException(
                "Price amount cannot exceed " + MAX_PRICE + "."
            );
        }

        // Enforce maximum of 2 decimal places using HALF_UP rounding
        this.amount = amount.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
