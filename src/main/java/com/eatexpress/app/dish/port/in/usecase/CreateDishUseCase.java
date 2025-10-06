package com.eatexpress.app.dish.port.in.usecase;

import com.eatexpress.app.dish.port.in.command.CreateDishCommand;

public interface CreateDishUseCase {
    void handle(CreateDishCommand command);
}
