package com.eatexpress.app.pricerange.adapter.out.db;

import com.eatexpress.app.common.events.DomainEvent;
import com.eatexpress.app.common.events.EventCatalog;
import com.eatexpress.app.common.events.RestaurantAveragePriceChangeEvent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "price_range_events", schema = "price_range")
public class PriceRangeEventJpaEntity {

    @Id
    private UUID uuid;

    @Column(nullable = false)
    private LocalDateTime eventPit;

    @Column(nullable = false, length = 50)
    private String eventType;

    @Column(nullable = false, scale = 2)
    private BigDecimal averagePrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pricerange_uuid", updatable = false)
    private PriceRangeJpaEntity pricerange;

    public PriceRangeEventJpaEntity() {}

    public PriceRangeEventJpaEntity(
        UUID uuid,
        LocalDateTime eventPit,
        String eventType,
        BigDecimal averagePrice,
        PriceRangeJpaEntity pricerange
    ) {
        this.uuid = uuid;
        this.eventPit = eventPit;
        this.eventType = eventType;
        this.averagePrice = averagePrice;
        this.pricerange = pricerange;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getEventPit() {
        return eventPit;
    }

    public void setEventPit(LocalDateTime eventPit) {
        this.eventPit = eventPit;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public PriceRangeJpaEntity getPricerange() {
        return pricerange;
    }

    public void setPricerange(PriceRangeJpaEntity pricerange) {
        this.pricerange = pricerange;
    }

    public RestaurantAveragePriceChangeEvent toDomain(UUID restaurantUuid) {
        return new RestaurantAveragePriceChangeEvent(
            uuid,
            EventCatalog.valueOf(eventType),
            eventPit,
            restaurantUuid,
            averagePrice
        );
    }
}
