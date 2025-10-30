package com.eatexpress.app.restaurant.domain;

import com.eatexpress.app.common.domain.Address;
import com.eatexpress.app.common.domain.Email;
import com.eatexpress.app.common.domain.Url;
import com.eatexpress.app.common.domain.UserId;
import java.util.UUID;

public class Restaurant {

    private RestaurantUUID restaurantUUID;

    public record RestaurantUUID(UUID uuid) {}

    private UserId owner;
    private String name;
    private CuisineType cuisineType;
    private Email contactEmail;
    private Url pictureUrl;
    private Address address;
    private Integer defaultPreparationTimeMinutes;
    private PriceRange priceRange;
    private OpeningHours openingHours;
    private RestaurantStatus openingStatusOverride;

    public Restaurant() {}

    public Restaurant(
        UserId owner,
        String name,
        CuisineType cuisineType,
        Email contactEmail,
        Url pictureUrl,
        Address address,
        Integer defaultPreparationTimeMinutes,
        PriceRange priceRange,
        OpeningHours openingHours,
        RestaurantStatus openingStatusOverride
    ) {
        this.owner = owner;
        this.name = name;
        this.cuisineType = cuisineType;
        this.contactEmail = contactEmail;
        this.pictureUrl = pictureUrl;
        this.address = address;
        this.defaultPreparationTimeMinutes = defaultPreparationTimeMinutes;
        this.priceRange = priceRange;
        this.openingHours = openingHours;
        this.openingStatusOverride = openingStatusOverride;
    }

    public Restaurant(
        RestaurantUUID restaurantUUID,
        UserId owner,
        String name,
        CuisineType cuisineType,
        Email contactEmail,
        Url pictureUrl,
        Address address,
        Integer defaultPreparationTimeMinutes,
        PriceRange priceRange,
        OpeningHours openingHours,
        RestaurantStatus openingStatusOverride
    ) {
        this.restaurantUUID = restaurantUUID;
        this.owner = owner;
        this.name = name;
        this.cuisineType = cuisineType;
        this.contactEmail = contactEmail;
        this.pictureUrl = pictureUrl;
        this.address = address;
        this.defaultPreparationTimeMinutes = defaultPreparationTimeMinutes;
        this.priceRange = priceRange;
        this.openingHours = openingHours;
        this.openingStatusOverride = openingStatusOverride;
    }

    public RestaurantUUID getRestaurantUUID() {
        return restaurantUUID;
    }

    public UserId getOwner() {
        return owner;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public Url getPictureUrl() {
        return pictureUrl;
    }

    public void setRestaurantUUID(RestaurantUUID restaurantUUID) {
        this.restaurantUUID = restaurantUUID;
    }

    public void setOwner(UserId owner) {
        this.owner = owner;
    }

    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }

    public Email getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(Email contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setPictureUrl(Url pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDefaultPreparationTimeMinutes() {
        return defaultPreparationTimeMinutes;
    }

    public void setDefaultPreparationTimeMinutes(
        Integer defaultPreparationTimeMinutes
    ) {
        this.defaultPreparationTimeMinutes = defaultPreparationTimeMinutes;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }

    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    public RestaurantStatus getOpeningStatusOverride() {
        return openingStatusOverride;
    }

    public void setOpeningStatusOverride(
        RestaurantStatus openingStatusOverride
    ) {
        this.openingStatusOverride = openingStatusOverride;
    }

    public void setOpeningHours(OpeningHours openingHours) {
        this.openingHours = openingHours;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
