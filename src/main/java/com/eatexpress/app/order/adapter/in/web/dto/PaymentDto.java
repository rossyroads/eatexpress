package com.eatexpress.app.order.adapter.in.web.dto;

import java.math.BigDecimal;

public class PaymentDto {

    private BigDecimal amount;
    private String paymentStatus;

    public PaymentDto(BigDecimal amount, String paymentStatus) {
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
