package com.eatexpress.app.pricerange.adapter.out.db;

import com.eatexpress.app.pricerange.domain.PriceRange;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "price_range", schema = "price_range")
public class PriceRangeJpaEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private UUID restaurantUuid;

    @OneToMany(
        mappedBy = "pricerange",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<PriceRangeEventJpaEntity> events = new ArrayList<>();

    public PriceRangeJpaEntity() {}

    public PriceRangeJpaEntity(UUID id, UUID restaurantUuid) {
        this.id = id;
        this.restaurantUuid = restaurantUuid;
    }

    public PriceRangeJpaEntity(
        UUID uuid,
        UUID restaurant,
        List<PriceRangeEventJpaEntity> events
    ) {
        this.id = uuid;
        this.restaurantUuid = restaurant;
        this.events = events;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID uuid) {
        this.id = uuid;
    }

    public UUID getRestaurantUuid() {
        return restaurantUuid;
    }

    public void setRestaurantUuid(UUID restaurant) {
        this.restaurantUuid = restaurant;
    }

    public List<PriceRangeEventJpaEntity> getEvents() {
        return events;
    }

    public void setEvents(List<PriceRangeEventJpaEntity> events) {
        this.events = events;
    }

    public PriceRange toDomain() {
        return new PriceRange(
            this.id,
            this.restaurantUuid,
            this.events.stream()
                .map(p -> p.toDomain(this.restaurantUuid))
                .collect(Collectors.toList())
        );
    }
}
