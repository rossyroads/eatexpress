package com.eatexpress.app.dish.port.in.usecase;

import com.eatexpress.app.dish.domain.DishAggregate;
import com.eatexpress.app.dish.domain.DishAggregate.RestaurantUUID;
import java.util.List;

public interface FindDishUseCase {
    List<DishAggregate> findAllByRestaurant(RestaurantUUID restaurantUUID);
}
