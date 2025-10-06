package com.eatexpress.app.dish.events;

import com.eatexpress.app.dish.domain.DishAggregate.DishUUID;
import com.eatexpress.app.dish.domain.DishAggregate.RestaurantUUID;
import com.eatexpress.app.dish.domain.DishDetails;
import java.time.Instant;
import java.util.UUID;

public class DishCreatedEvent implements DishEvent {

    private final UUID eventId;
    private final Instant timestamp = Instant.now();
    private final long version = 1;
    private final DishUUID dishId;
    private final RestaurantUUID restaurantId;
    private final DishDetails initialDetails;

    public DishCreatedEvent(
        DishUUID dishId,
        RestaurantUUID restaurantId,
        DishDetails initialDetails,
        UUID eventId
    ) {
        this.eventId = eventId;
        this.dishId = dishId;
        this.restaurantId = restaurantId;
        this.initialDetails = initialDetails;
    }

    // Getters
    public UUID getEventId() {
        return eventId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public long getVersion() {
        return version;
    }

    public DishUUID getDishId() {
        return dishId;
    }

    public RestaurantUUID getRestaurantId() {
        return restaurantId;
    }

    public DishDetails getInitialDetails() {
        return initialDetails;
    }
}
