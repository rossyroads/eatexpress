package com.eatexpress.app.dish.port.in.command;

import com.eatexpress.app.dish.domain.DishAggregate.DishUUID;
import com.eatexpress.app.dish.domain.DishStatus;

public final class StatusSetDishCommand implements DishCommand {

    private DishUUID dishId;
    private DishStatus newStatus;

    public StatusSetDishCommand(DishUUID dishId, DishStatus newStatus) {
        this.dishId = dishId;
        this.newStatus = newStatus;
    }

    public DishUUID getDishId() {
        return dishId;
    }

    public DishStatus getNewStatus() {
        return newStatus;
    }
}
