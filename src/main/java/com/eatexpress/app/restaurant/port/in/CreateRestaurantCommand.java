package com.eatexpress.app.restaurant.port.in;

import static java.util.Objects.requireNonNull;

import com.eatexpress.app.common.domain.Address;
import com.eatexpress.app.common.domain.Email;
import com.eatexpress.app.common.domain.Url;
import com.eatexpress.app.common.domain.UserId;
import com.eatexpress.app.restaurant.domain.CuisineType;
import com.eatexpress.app.restaurant.domain.OpeningHours;

public record CreateRestaurantCommand(
    UserId owner,
    String name,
    CuisineType cuisineType,
    Email contactEmail,
    Url pictureUrl,
    Address address,
    Integer defaultPreparationTimeMinutes,
    OpeningHours openingHours
) {
    public CreateRestaurantCommand {
        requireNonNull(owner);
        requireNonNull(name);
        requireNonNull(contactEmail);
    }
}
