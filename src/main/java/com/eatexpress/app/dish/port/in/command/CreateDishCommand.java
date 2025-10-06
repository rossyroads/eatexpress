package com.eatexpress.app.dish.port.in.command;

import com.eatexpress.app.dish.domain.DishAggregate.DishUUID;
import com.eatexpress.app.dish.domain.DishAggregate.RestaurantUUID;
import com.eatexpress.app.dish.domain.DishDetails;
import java.util.Objects;

public final class CreateDishCommand implements DishCommand {

    private final DishUUID dishId;
    private final RestaurantUUID restaurantId;
    private final DishDetails initialDetails;
    private final boolean isOutOfStock;

    public CreateDishCommand(
        DishUUID dishId,
        RestaurantUUID restaurantId,
        DishDetails initialDetails,
        boolean isOutOfStock
    ) {
        this.dishId = Objects.requireNonNull(dishId);
        this.restaurantId = Objects.requireNonNull(restaurantId);
        this.initialDetails = Objects.requireNonNull(initialDetails);
        this.isOutOfStock = isOutOfStock;
    }

    // Getters
    @Override
    public DishUUID getDishId() {
        return dishId;
    }

    public RestaurantUUID getRestaurantId() {
        return restaurantId;
    }

    public DishDetails getInitialDetails() {
        return initialDetails;
    }

    public boolean isOutOfStock() {
        return isOutOfStock;
    }
}
