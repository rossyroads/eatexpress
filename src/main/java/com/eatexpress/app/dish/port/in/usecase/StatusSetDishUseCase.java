package com.eatexpress.app.dish.port.in.usecase;

import com.eatexpress.app.dish.port.in.command.StatusSetDishCommand;

public interface StatusSetDishUseCase {
    void handle(StatusSetDishCommand command);
}
