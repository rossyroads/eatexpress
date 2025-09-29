package com.eatexpress.app.restaurant.adapter.in.web.dto;

import java.util.ArrayList;

public class RestaurantDto {

    private String name;
    private String cuisineType;
    private String contactEmail;
    private String pictureUrl;
    private String street;
    private Integer street_number;
    private String postalCode;
    private String city;
    private String country;
    private Integer defaultPreparationTimeMinutes;
    private ArrayList<DailyScheduleDto> openingHours;

    public RestaurantDto(
        String name,
        String cuisineType,
        String contactEmail,
        String pictureUrl,
        String street,
        Integer street_number,
        String postalCode,
        String city,
        String country,
        Integer defaultPreparationTimeMinutes,
        ArrayList<DailyScheduleDto> openingHours
    ) {
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
        this.openingHours = openingHours;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return street_number;
    }

    public void setNumber(Integer street_number) {
        this.street_number = street_number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
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

    public Integer getStreet_number() {
        return street_number;
    }

    public void setStreet_number(Integer street_number) {
        this.street_number = street_number;
    }

    public Integer getDefaultPreparationTimeMinutes() {
        return defaultPreparationTimeMinutes;
    }

    public void setDefaultPreparationTimeMinutes(
        Integer defaultPreparationTimeMinutes
    ) {
        this.defaultPreparationTimeMinutes = defaultPreparationTimeMinutes;
    }

    public ArrayList<DailyScheduleDto> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(ArrayList<DailyScheduleDto> openingHours) {
        this.openingHours = openingHours;
    }
}
