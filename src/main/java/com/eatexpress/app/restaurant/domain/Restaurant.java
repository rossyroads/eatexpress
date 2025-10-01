package com.eatexpress.app.restaurant.domain;

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
    private String street;
    private Integer street_number;
    private String postalCode;
    private String city;
    private String country;
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
        String street,
        Integer street_number,
        String postalCode,
        String city,
        String country,
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
        this.street = street;
        this.street_number = street_number;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
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
        String street,
        Integer street_number,
        String postalCode,
        String city,
        String country,
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
        this.street = street;
        this.street_number = street_number;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
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

    public String getStreet() {
        return street;
    }

    public Integer getStreet_number() {
        return street_number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
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

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreet_number(Integer number) {
        this.street_number = number;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
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
}
