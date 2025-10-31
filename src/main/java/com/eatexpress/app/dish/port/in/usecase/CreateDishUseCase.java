package com.eatexpress.app.dish.port.in.usecase;

import com.eatexpress.app.dish.domain.DishAggregate;
import com.eatexpress.app.dish.port.in.command.CreateDishCommand;

public interface CreateDishUseCase {
    DishAggregate handle(CreateDishCommand command);
}
