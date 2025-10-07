package com.eatexpress.app.order.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Payment {

    private UUID paymentId;
    private BigDecimal amount;
    private PaymentStatus paymentStatus;

    public Payment(BigDecimal amount, PaymentStatus paymentStatus) {
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }
}
