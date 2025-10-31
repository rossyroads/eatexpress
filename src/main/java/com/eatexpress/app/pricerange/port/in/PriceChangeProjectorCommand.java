package com.eatexpress.app.pricerange.port.in;

import com.eatexpress.app.restaurant.domain.Restaurant.RestaurantUUID;
import java.math.BigDecimal;

public record PriceChangeProjectorCommand(
    RestaurantUUID uuid,
    BigDecimal averagePrice
) {}
