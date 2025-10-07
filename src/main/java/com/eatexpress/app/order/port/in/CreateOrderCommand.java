package com.eatexpress.app.order.port.in;

import com.eatexpress.app.order.domain.ContactInfo;
import com.eatexpress.app.order.domain.OrderedDish;
import com.eatexpress.app.order.domain.Payment;
import java.util.List;

public final class CreateOrderCommand {

    private final ContactInfo contactInfo;
    private final List<OrderedDish> orderedDishes;
    private final Payment payment;

    public CreateOrderCommand(
        ContactInfo contactInfo,
        List<OrderedDish> orderedDishes,
        Payment payment
    ) {
        this.contactInfo = contactInfo;
        this.orderedDishes = orderedDishes;
        this.payment = payment;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public List<OrderedDish> getOrderedDishes() {
        return orderedDishes;
    }

    public Payment getPayment() {
        return payment;
    }
}
