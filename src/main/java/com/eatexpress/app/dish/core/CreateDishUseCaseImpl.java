package com.eatexpress.app.dish.core;

import com.eatexpress.app.dish.domain.DishAggregate;
import com.eatexpress.app.dish.domain.DishStatus;
import com.eatexpress.app.dish.port.in.command.CreateDishCommand;
import com.eatexpress.app.dish.port.in.usecase.CalculateRestaurantAveragePriceUseCase;
import com.eatexpress.app.dish.port.in.usecase.CreateDishUseCase;
import com.eatexpress.app.dish.port.out.CreateDishPort;
import com.eatexpress.app.dish.port.out.UpdateAveragePricePort;
import org.springframework.stereotype.Service;

@Service
public class CreateDishUseCaseImpl implements CreateDishUseCase {

    private final CreateDishPort createDishPort;
    private final UpdateAveragePricePort updateAveragePricePort;
    private final CalculateRestaurantAveragePriceUseCase calculateRestaurantAveragePriceUseCase;

    public CreateDishUseCaseImpl(
        CreateDishPort dishPort,
        UpdateAveragePricePort updateAveragePricePort,
        CalculateRestaurantAveragePriceUseCase calculateRestaurantAveragePriceUseCase
    ) {
        this.createDishPort = dishPort;
        this.updateAveragePricePort = updateAveragePricePort;
        this.calculateRestaurantAveragePriceUseCase =
            calculateRestaurantAveragePriceUseCase;
    }

    public DishAggregate handle(CreateDishCommand createDishCommand) {
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
        DishAggregate dishAggregateCreated = createDishPort.save(dishAggregate);

        updateAveragePricePort.update(
            createDishCommand.getRestaurantId(),
            calculateRestaurantAveragePriceUseCase.calculate(
                createDishCommand.getRestaurantId()
            )
        );
        return dishAggregateCreated;
    }
}
