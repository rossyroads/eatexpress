package com.eatexpress.app.restaurant.port.in;

import com.eatexpress.app.restaurant.domain.Restaurant;

public interface CreateRestaurantUseCase {
    Restaurant createRestaurant(CreateRestaurantCommand createRestaurantCommand);
}
