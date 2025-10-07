package com.eatexpress.app.order.adapter.in.web.dto;

import com.eatexpress.app.common.domain.Email;
import com.eatexpress.app.order.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderDtoMapper {
    Order map(OrderDto value);
    OrderDto map(Order value);

    default String map(Email email) {
        return email.email();
    }

    default Email mapEmail(String email) {
        return new Email(email);
    }
}
