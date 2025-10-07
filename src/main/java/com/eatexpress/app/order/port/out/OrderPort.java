package com.eatexpress.app.order.port.out;

import com.eatexpress.app.order.domain.Order;

public interface OrderPort {
    void save(Order order);
}
