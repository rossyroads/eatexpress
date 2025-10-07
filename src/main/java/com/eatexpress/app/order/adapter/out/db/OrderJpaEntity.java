package com.eatexpress.app.order.adapter.out.db;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "ordering", name = "orders")
public class OrderJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_id")
    private UUID orderId;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contact_info_id")
    private ContactInfoJpaEntity contactInfo;

    @OneToMany(
        mappedBy = "order",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<OrderedDishJpaEntity> orderedDishes = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "payment_id")
    private PaymentJpaEntity payment;

    private String orderStatus;

    private String messageToCustomer;

    public OrderJpaEntity() {}

    public OrderJpaEntity(
        UUID orderId,
        ContactInfoJpaEntity contactInfo,
        List<OrderedDishJpaEntity> orderedDishes,
        PaymentJpaEntity payment,
        String orderStatus,
        String messageToCustomer
    ) {
        this.orderId = orderId;
        this.contactInfo = contactInfo;
        this.orderedDishes = orderedDishes;
        this.payment = payment;
        this.orderStatus = orderStatus;
        this.messageToCustomer = messageToCustomer;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public ContactInfoJpaEntity getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfoJpaEntity contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<OrderedDishJpaEntity> getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(List<OrderedDishJpaEntity> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    public PaymentJpaEntity getPayment() {
        return payment;
    }

    public void setPayment(PaymentJpaEntity payment) {
        this.payment = payment;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getMessageToCustomer() {
        return messageToCustomer;
    }

    public void setMessageToCustomer(String messageToCustomer) {
        this.messageToCustomer = messageToCustomer;
    }
}
