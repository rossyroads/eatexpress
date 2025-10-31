package com.eatexpress.app.pricerange.domain;

import com.eatexpress.app.common.events.DomainEvent;
import com.eatexpress.app.common.events.RestaurantAveragePriceChangeEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class PriceRange {

    private UUID id;
    private UUID restaurantUuid;
    private List<DomainEvent> eventStore = new ArrayList<>();

    private final List<DomainEvent> uncommittedEvents = new ArrayList<>();

    public PriceRange(UUID id, UUID restaurantUuid) {
        this.id = id;
        this.restaurantUuid = restaurantUuid;
    }

    public PriceRange(
        UUID id,
        UUID restaurantUuid,
        List<DomainEvent> eventStore
    ) {
        this.id = id;
        this.restaurantUuid = restaurantUuid;
        this.eventStore = eventStore;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRestaurantUuid() {
        return restaurantUuid;
    }

    public void setRestaurantUuid(UUID restaurantUuid) {
        this.restaurantUuid = restaurantUuid;
    }

    public void changeAveragePrice(BigDecimal averagePrice) {
        this.uncommittedEvents.add(
            new RestaurantAveragePriceChangeEvent(restaurantUuid, averagePrice)
        );
    }

    public void commitEvents() {
        eventStore.addAll(uncommittedEvents);
        uncommittedEvents.clear();
    }

    public List<DomainEvent> getUncommittedEvents() {
        return uncommittedEvents;
    }

    public List<DomainEvent> getDomainEvents() {
        return new ArrayList<>(
            Stream.concat(
                eventStore.stream(),
                uncommittedEvents.stream()
            ).toList()
        );
    }
}
