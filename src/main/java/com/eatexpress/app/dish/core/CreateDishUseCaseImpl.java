package com.eatexpress.app.dish.core;

import com.eatexpress.app.dish.domain.DishAggregate;
import com.eatexpress.app.dish.domain.DishStatus;
import com.eatexpress.app.dish.port.in.command.CreateDishCommand;
import com.eatexpress.app.dish.port.in.usecase.CreateDishUseCase;
import com.eatexpress.app.dish.port.out.DishPort;
import org.springframework.stereotype.Service;

@Service
public class CreateDishUseCaseImpl implements CreateDishUseCase {

    private final DishPort dishPort;

    public CreateDishUseCaseImpl(DishPort dishPort) {
        this.dishPort = dishPort;
    }

    public void handle(CreateDishCommand createDishCommand) {
        DishAggregate dishAggregate = new DishAggregate(
            createDishCommand.getDishId(),
            createDishCommand.getRestaurantId(),
            createDishCommand.getInitialDetails(),
            null,
            DishStatus.PUBLISHED,
            createDishCommand.isOutOfStock(),
            null,
            0
        );
        dishPort.save(dishAggregate);
    }
}
