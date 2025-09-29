package com.eatexpress.app.restaurant.port.in;

import com.eatexpress.app.common.domain.Email;
import com.eatexpress.app.common.domain.Url;
import com.eatexpress.app.restaurant.domain.CuisineType;
import com.eatexpress.app.restaurant.domain.OpeningHours;

import static java.util.Objects.requireNonNull;


public record CreateRestaurantCommand(String name, CuisineType cuisineType, Email contactEmail, Url pictureUrl, String street,
            Integer street_number, String postalCode, String city, String country, Integer defaultPreparationTimeMinutes,
            OpeningHours openingHours) {
    public CreateRestaurantCommand{
        requireNonNull(name);
        requireNonNull(contactEmail);
    }
}
