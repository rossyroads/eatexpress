package com.eatexpress.app.common.events;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record RestaurantAveragePriceChangeEvent(
    UUID uuid,
    EventCatalog eventCatalog,
    LocalDateTime eventPit,
    UUID restaurantUUID,
    BigDecimal averagePrice
) implements DomainEvent {
    public RestaurantAveragePriceChangeEvent(
        UUID restaurantUUID,
        BigDecimal averagePrice
    ) {
        this(
            UUID.randomUUID(),
            EventCatalog.RESTAURANT_AVERAGE_PRICE_CHANGE_EVENT,
            LocalDateTime.now(),
            restaurantUUID,
            averagePrice
        );
    }
}
