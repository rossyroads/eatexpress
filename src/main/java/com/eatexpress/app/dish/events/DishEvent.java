package com.eatexpress.app.dish.events;

import com.eatexpress.app.dish.domain.DishAggregate.DishUUID;
import java.time.Instant;
import java.util.UUID;

public interface DishEvent {
    UUID getEventId();
    DishUUID getDishId();
    Instant getTimestamp();
    long getVersion();
}
