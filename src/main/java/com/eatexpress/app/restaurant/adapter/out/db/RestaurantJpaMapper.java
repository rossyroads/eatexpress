package com.eatexpress.app.restaurant.adapter.out.db;

import com.eatexpress.app.order.adapter.out.db.OrderJpaEntity;
import com.eatexpress.app.restaurant.domain.Restaurant;
import com.eatexpress.app.restaurant.domain.Restaurant.RestaurantUUID;
import java.util.UUID;
import org.mapstruct.AfterMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    uses = { DailyScheduleJpaMapper.class }
)
public interface RestaurantJpaMapper {
    @Mapping(target = "uuid", source = "restaurantUUID")
    RestaurantJpaEntity map(Restaurant restaurant);

    @InheritInverseConfiguration
    Restaurant map(RestaurantJpaEntity restaurantJpaEntity);

    default UUID map(RestaurantUUID value) {
        return value.uuid();
    }

    default RestaurantUUID map(UUID value) {
        return new RestaurantUUID(value);
    }

    @AfterMapping
    default void linkOpeningHours(@MappingTarget OrderJpaEntity order) {
        if (order.getOrderedDishes() != null) {
            order.getOrderedDishes().forEach(c -> c.setOrder(order));
        }
    }
}
