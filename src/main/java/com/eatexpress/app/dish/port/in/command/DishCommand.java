package com.eatexpress.app.dish.port.in.command;

import com.eatexpress.app.dish.domain.DishAggregate.DishUUID;

public interface DishCommand {
    DishUUID getDishId();
}
