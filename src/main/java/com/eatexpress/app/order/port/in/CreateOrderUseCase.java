package com.eatexpress.app.order.port.in;

public interface CreateOrderUseCase {
    void handle(CreateOrderCommand command);
}
