package com.eatexpress.app.restaurant.port.in;

import com.eatexpress.app.common.domain.UserId;
import com.eatexpress.app.restaurant.domain.Restaurant;

public interface FindRestaurantUseCase {
    Restaurant findRestaurantByOwner(UserId ownerId);
}
