package com.eatexpress.app.restaurant.port.out;

import com.eatexpress.app.restaurant.domain.Restaurant;
import java.util.UUID;

public interface RestaurantFindPort {
    Restaurant findRestaurantByOwner(UUID ownerId);
    boolean checkRestaurantByOwnerExists(UUID ownerId);
}
