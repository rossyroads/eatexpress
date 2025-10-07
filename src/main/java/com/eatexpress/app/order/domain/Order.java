package com.eatexpress.app.order.domain;

import java.util.List;
import java.util.UUID;

public class Order {

    private UUID orderId;
    private ContactInfo contactInfo;
    private List<OrderedDish> orderedDishes;
    private Payment payment;
    private OrderStatus orderStatus;

    private String messageToCustomer;

    public Order() {}

    public Order(
        ContactInfo contactInfo,
        List<OrderedDish> orderedDishes,
        Payment payment,
        OrderStatus orderStatus
    ) {
        this.contactInfo = contactInfo;
        this.orderedDishes = orderedDishes;
        this.payment = payment;
        this.orderStatus = orderStatus;
    }

    public Order(
        ContactInfo contactInfo,
        List<OrderedDish> orderedDishes,
        Payment payment,
        OrderStatus orderStatus,
        String messageToCustomer
    ) {
        this.contactInfo = contactInfo;
        this.orderedDishes = orderedDishes;
        this.payment = payment;
        this.orderStatus = orderStatus;
        this.messageToCustomer = messageToCustomer;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<OrderedDish> getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(List<OrderedDish> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getMessageToCustomer() {
        return messageToCustomer;
    }

    public void setMessageToCustomer(String messageToCustomer) {
        this.messageToCustomer = messageToCustomer;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
}
