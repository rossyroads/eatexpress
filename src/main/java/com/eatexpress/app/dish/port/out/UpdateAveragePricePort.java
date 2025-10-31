package com.eatexpress.app.dish.port.out;

import com.eatexpress.app.dish.domain.DishAggregate.RestaurantUUID;
import java.math.BigDecimal;

public interface UpdateAveragePricePort {
    void update(RestaurantUUID uuid, BigDecimal averagePrice);
}
