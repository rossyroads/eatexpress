package com.eatexpress.app.dish.port.in.usecase;

import com.eatexpress.app.dish.domain.DishAggregate.RestaurantUUID;
import java.math.BigDecimal;

public interface CalculateRestaurantAveragePriceUseCase {
    BigDecimal calculate(RestaurantUUID uuid);
}
