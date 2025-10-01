package com.eatexpress.app.restaurant.core;

import com.eatexpress.app.restaurant.domain.PriceRange;
import com.eatexpress.app.restaurant.domain.Restaurant;
import com.eatexpress.app.restaurant.domain.Restaurant.RestaurantUUID;
import com.eatexpress.app.restaurant.domain.RestaurantStatus;
import com.eatexpress.app.restaurant.port.in.CreateRestaurantCommand;
import com.eatexpress.app.restaurant.port.in.CreateRestaurantUseCase;
import com.eatexpress.app.restaurant.port.out.RestaurantCreatePort;
import java.util.UUID;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class CreateRestaurantUseCaseImpl implements CreateRestaurantUseCase {

    private static final Logger log = Logger.getLogger(
        CreateRestaurantUseCaseImpl.class.getName()
    );

    private final RestaurantCreatePort restaurantCreatePort;

    public CreateRestaurantUseCaseImpl(
        RestaurantCreatePort restaurantCreatePort
    ) {
        this.restaurantCreatePort = restaurantCreatePort;
    }

    public Restaurant createRestaurant(
        CreateRestaurantCommand createRestaurantCommand
    ) {
        log.info("Creating restaurant: " + createRestaurantCommand.name());
        Restaurant restaurant = new Restaurant(
            new RestaurantUUID(UUID.randomUUID()),
            createRestaurantCommand.owner(),
            createRestaurantCommand.name(),
            createRestaurantCommand.cuisineType(),
            createRestaurantCommand.contactEmail(),
            createRestaurantCommand.pictureUrl(),
            createRestaurantCommand.street(),
            createRestaurantCommand.street_number(),
            createRestaurantCommand.postalCode(),
            createRestaurantCommand.city(),
            createRestaurantCommand.country(),
            createRestaurantCommand.defaultPreparationTimeMinutes(),
            PriceRange.REGULAR,
            createRestaurantCommand.openingHours(),
            RestaurantStatus.USUAL
        );

        restaurantCreatePort.createRestaurant(restaurant);
        log.info("Created restaurant: " + createRestaurantCommand.name());

        return restaurant;
    }
}
