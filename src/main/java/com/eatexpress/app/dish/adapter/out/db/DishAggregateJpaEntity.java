package com.eatexpress.app.dish.adapter.out.db;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(schema = "dish", name = "dish_aggregate")
public class DishAggregateJpaEntity {

    @Id
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID uuid;

    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID restaurant;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "live_details_id", unique = true, nullable = false)
    private DishDetailsJpaEntity liveState;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "draft_details_id", unique = true, nullable = true)
    private DishDetailsJpaEntity draftState;

    private String liveStatus;
    private boolean isOutOfStock;
    private LocalDateTime scheduledTime;
    private long version;

    public DishAggregateJpaEntity() {}

    public DishAggregateJpaEntity(
        UUID uuid,
        UUID restaurant,
        DishDetailsJpaEntity liveState,
        DishDetailsJpaEntity draftState,
        String liveStatus,
        boolean isOutOfStock,
        LocalDateTime scheduledTime,
        long version
    ) {
        this.uuid = uuid;
        this.restaurant = restaurant;
        this.liveState = liveState;
        this.draftState = draftState;
        this.liveStatus = liveStatus;
        this.isOutOfStock = isOutOfStock;
        this.scheduledTime = scheduledTime;
        this.version = version;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(UUID restaurant) {
        this.restaurant = restaurant;
    }

    public DishDetailsJpaEntity getLiveState() {
        return liveState;
    }

    public void setLiveState(DishDetailsJpaEntity liveState) {
        this.liveState = liveState;
    }

    public DishDetailsJpaEntity getDraftState() {
        return draftState;
    }

    public void setDraftState(DishDetailsJpaEntity draftState) {
        this.draftState = draftState;
    }

    public String getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(String liveStatus) {
        this.liveStatus = liveStatus;
    }

    public boolean getIsOutOfStock() {
        return isOutOfStock;
    }

    public void setIsOutOfStock(boolean isOutOfStock) {
        this.isOutOfStock = isOutOfStock;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
