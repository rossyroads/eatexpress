package com.eatexpress.app.dish.core;

import com.eatexpress.app.dish.domain.DishAggregate;
import com.eatexpress.app.dish.domain.DishAggregate.RestaurantUUID;
import com.eatexpress.app.dish.port.in.usecase.FindDishUseCase;
import com.eatexpress.app.dish.port.out.DishPort;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FindDishUseCaseImpl implements FindDishUseCase {

    private final DishPort dishPort;

    public FindDishUseCaseImpl(DishPort dishPort) {
        this.dishPort = dishPort;
    }

    public List<DishAggregate> findAllByRestaurant(
        RestaurantUUID restaurantUUID
    ) {
        return dishPort.findAllByRestaurant(restaurantUUID);
    }
}
