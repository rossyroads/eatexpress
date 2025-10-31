package com.eatexpress.app.restaurant.core;

import com.eatexpress.app.common.domain.GeocodePlace;
import com.eatexpress.app.common.exceptions.AddressUnknownException;
import com.eatexpress.app.common.service.GeocodeService;
import com.eatexpress.app.restaurant.domain.PriceRange;
import com.eatexpress.app.restaurant.domain.Restaurant;
import com.eatexpress.app.restaurant.domain.Restaurant.RestaurantUUID;
import com.eatexpress.app.restaurant.domain.RestaurantStatus;
import com.eatexpress.app.restaurant.exceptions.RestaurantAlreadyExistsException;
import com.eatexpress.app.restaurant.port.in.CreateRestaurantCommand;
import com.eatexpress.app.restaurant.port.in.CreateRestaurantUseCase;
import com.eatexpress.app.restaurant.port.out.RestaurantCreatePort;
import com.eatexpress.app.restaurant.port.out.RestaurantFindPort;
import java.net.MalformedURLException;
import java.util.UUID;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class CreateRestaurantUseCaseImpl implements CreateRestaurantUseCase {

    private static final Logger log = Logger.getLogger(
        CreateRestaurantUseCaseImpl.class.getName()
    );

    private final RestaurantCreatePort restaurantCreatePort;
    private final RestaurantFindPort restaurantFindPort;
    private final GeocodeService geocodeService;

    public CreateRestaurantUseCaseImpl(
        RestaurantCreatePort restaurantCreatePort,
        RestaurantFindPort restaurantFindPort,
        GeocodeService geocodeService
    ) {
        this.restaurantCreatePort = restaurantCreatePort;
        this.restaurantFindPort = restaurantFindPort;
        this.geocodeService = geocodeService;
    }

    public Restaurant createRestaurant(
        CreateRestaurantCommand createRestaurantCommand
    ) {
        if (
            restaurantFindPort.checkRestaurantByOwnerExists(
                createRestaurantCommand.owner().uuid()
            )
        ) {
            throw new RestaurantAlreadyExistsException();
        }
        log.info("Creating restaurant: " + createRestaurantCommand.name());

        try {
            GeocodePlace[] geocodeAddresses =
                geocodeService.getCoordinatesByAddress(
                    createRestaurantCommand.address()
                );
            if (
                geocodeAddresses.length == 0
            ) throw new AddressUnknownException();
            createRestaurantCommand
                .address()
                .setLatitude(geocodeAddresses[0].getLat());
            createRestaurantCommand
                .address()
                .setLongitude(geocodeAddresses[0].getLon());
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Restaurant restaurant = new Restaurant(
            new RestaurantUUID(UUID.randomUUID()),
            createRestaurantCommand.owner(),
            createRestaurantCommand.name(),
            createRestaurantCommand.cuisineType(),
            createRestaurantCommand.contactEmail(),
            createRestaurantCommand.pictureUrl(),
            createRestaurantCommand.address(),
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
