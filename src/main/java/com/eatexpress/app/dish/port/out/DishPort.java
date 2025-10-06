package com.eatexpress.app.dish.port.out;

import com.eatexpress.app.dish.domain.DishAggregate;
import com.eatexpress.app.dish.domain.DishAggregate.DishUUID;

public interface DishPort {
    void save(DishAggregate dishAggregate);
    DishAggregate loadById(DishUUID uuid);
}
