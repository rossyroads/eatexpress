package com.eatexpress.app.dish.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class DishAggregate {

    public record DishUUID(UUID uuid) {}

    public record RestaurantUUID(UUID uuid) {}

    private DishUUID uuid;
    private RestaurantUUID restaurant;
    private DishDetails liveState;
    private DishDetails draftState;
    private DishStatus liveStatus = DishStatus.UNPUBLISHED;
    private boolean isOutOfStock = false;
    private LocalDateTime scheduledTime = null; // When a pending change should go live
    private long version = 0;

    public DishAggregate() {}

    public DishAggregate(DishUUID uuid) {
        this.uuid = uuid;
    }

    public DishAggregate(
        DishUUID dishId,
        RestaurantUUID restaurant,
        DishDetails liveState,
        DishDetails draftState,
        DishStatus liveStatus,
        boolean isOutOfStock,
        LocalDateTime scheduledTime,
        long version
    ) {
        this.uuid = dishId;
        this.restaurant = restaurant;
        this.liveState = liveState;
        this.draftState = draftState;
        this.liveStatus = liveStatus;
        this.isOutOfStock = isOutOfStock;
        this.scheduledTime = scheduledTime;
        this.version = version;
    }

    public DishUUID getUuid() {
        return uuid;
    }

    public void setUuid(DishUUID dishId) {
        this.uuid = dishId;
    }

    public RestaurantUUID getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantUUID restaurant) {
        this.restaurant = restaurant;
    }

    public DishDetails getLiveState() {
        return liveState;
    }

    public void setLiveState(DishDetails liveState) {
        this.liveState = liveState;
    }

    public DishDetails getDraftState() {
        return draftState;
    }

    public void setDraftState(DishDetails draftState) {
        this.draftState = draftState;
    }

    public DishStatus getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(DishStatus liveStatus) {
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
