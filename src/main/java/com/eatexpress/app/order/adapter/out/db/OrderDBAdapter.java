package com.eatexpress.app.order.adapter.out.db;

import com.eatexpress.app.order.domain.Order;
import com.eatexpress.app.order.port.out.OrderPort;
import org.springframework.stereotype.Service;

@Service
public class OrderDBAdapter implements OrderPort {

    private final OrderRepository orderRepository;
    private final OrderJpaMapper orderJpaMapper;

    public OrderDBAdapter(
        OrderRepository orderRepository,
        OrderJpaMapper orderJpaMapper
    ) {
        this.orderRepository = orderRepository;
        this.orderJpaMapper = orderJpaMapper;
    }

    public void save(Order order) {
        orderRepository.save(orderJpaMapper.map(order));
    }
}
