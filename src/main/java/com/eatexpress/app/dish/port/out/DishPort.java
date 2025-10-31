package com.eatexpress.app.dish.port.out;

import com.eatexpress.app.dish.domain.DishAggregate;
import com.eatexpress.app.dish.domain.DishAggregate.DishUUID;
import com.eatexpress.app.dish.domain.DishAggregate.RestaurantUUID;
import java.util.List;

public interface DishPort {
    DishAggregate loadById(DishUUID uuid);
    List<DishAggregate> findAllByRestaurant(RestaurantUUID restaurantUUID);
}
