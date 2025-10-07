package com.eatexpress.app.order.adapter.in.web.dto;

import java.util.List;

public class OrderDto {

    private ContactInfoDto contactInfo;
    private List<OrderedDishDto> orderedDishes;
    private PaymentDto payment;
    private String orderStatus;

    public OrderDto(
        ContactInfoDto contactInfo,
        List<OrderedDishDto> orderedDishes,
        PaymentDto payment,
        String orderStatus
    ) {
        this.contactInfo = contactInfo;
        this.orderedDishes = orderedDishes;
        this.payment = payment;
        this.orderStatus = orderStatus;
    }

    public ContactInfoDto getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfoDto contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<OrderedDishDto> getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(List<OrderedDishDto> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    public PaymentDto getPayment() {
        return payment;
    }

    public void setPayment(PaymentDto payment) {
        this.payment = payment;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
