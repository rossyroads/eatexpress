package com.eatexpress.app.order.adapter.out.db;

import com.eatexpress.app.common.domain.Email;
import com.eatexpress.app.order.domain.Order;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderJpaMapper {
    Order map(OrderJpaEntity value);
    OrderJpaEntity map(Order value);

    default String map(Email email) {
        return email.email();
    }

    default Email mapEmail(String email) {
        return new Email(email);
    }

    @AfterMapping
    default void linkOrderedDishes(@MappingTarget OrderJpaEntity order) {
        if (order.getOrderedDishes() != null) {
            order.getOrderedDishes().forEach(c -> c.setOrder(order));
        }
    }
}
