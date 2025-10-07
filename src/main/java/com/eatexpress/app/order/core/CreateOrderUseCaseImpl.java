package com.eatexpress.app.order.core;

import com.eatexpress.app.order.domain.Order;
import com.eatexpress.app.order.domain.OrderStatus;
import com.eatexpress.app.order.port.in.CreateOrderCommand;
import com.eatexpress.app.order.port.in.CreateOrderUseCase;
import com.eatexpress.app.order.port.out.OrderPort;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private final OrderPort orderPort;

    public CreateOrderUseCaseImpl(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public void handle(CreateOrderCommand command) {
        Order order = new Order();
        order.setContactInfo(command.getContactInfo());
        order.setOrderStatus(OrderStatus.PLACED);
        order.setOrderedDishes(command.getOrderedDishes());
        order.setPayment(command.getPayment());
        orderPort.save(order);
    }
}
