package com.eatexpress.app.restaurant.port.out;

import com.eatexpress.app.restaurant.domain.Restaurant;

public interface RestaurantCreatePort {
    void createRestaurant(Restaurant restaurant);
}
