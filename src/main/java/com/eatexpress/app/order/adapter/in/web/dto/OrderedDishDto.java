package com.eatexpress.app.order.adapter.in.web.dto;

import java.util.UUID;

public class OrderedDishDto {

    private UUID restaurantId;
    private UUID dishId;

    public OrderedDishDto(UUID restaurantId, UUID dishId) {
        this.restaurantId = restaurantId;
        this.dishId = dishId;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(UUID restaurantId) {
        this.restaurantId = restaurantId;
    }

    public UUID getDishId() {
        return dishId;
    }

    public void setDishId(UUID dishId) {
        this.dishId = dishId;
    }
}
