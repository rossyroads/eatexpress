package com.eatexpress.app.restaurant.core;

import com.eatexpress.app.common.domain.UserId;
import com.eatexpress.app.restaurant.domain.Restaurant;
import com.eatexpress.app.restaurant.port.in.FindRestaurantUseCase;
import com.eatexpress.app.restaurant.port.out.RestaurantFindPort;
import org.springframework.stereotype.Service;

@Service
public class FindRestaurantUseCaseImpl implements FindRestaurantUseCase {

    private final RestaurantFindPort restaurantFindPort;

    public FindRestaurantUseCaseImpl(RestaurantFindPort restaurantFindPort) {
        this.restaurantFindPort = restaurantFindPort;
    }

    public Restaurant findRestaurantByOwner(UserId ownerId) {
        Restaurant restaurant = restaurantFindPort.findRestaurantByOwner(
            ownerId.uuid()
        );
        return restaurant;
    }
}
