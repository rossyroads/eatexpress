package com.eatexpress.app.dish.port.out;

import com.eatexpress.app.dish.domain.DishAggregate;

public interface CreateDishPort {
    DishAggregate save(DishAggregate dishAggregate);
}
