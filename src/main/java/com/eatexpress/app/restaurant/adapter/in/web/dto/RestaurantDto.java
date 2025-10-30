package com.eatexpress.app.restaurant.adapter.in.web.dto;

import com.eatexpress.app.common.domain.Address;
import java.util.ArrayList;

public class RestaurantDto {

    private String uuid;
    private String name;
    private String cuisineType;
    private String contactEmail;
    private String pictureUrl;
    private Address address;
    private Integer defaultPreparationTimeMinutes;
    private String priceRange;
    private ArrayList<DailyScheduleDto> openingHours;
    private String openingStatusOverride;

    public RestaurantDto(
        String name,
        String cuisineType,
        String contactEmail,
        String pictureUrl,
        Address address,
        Integer defaultPreparationTimeMinutes,
        ArrayList<DailyScheduleDto> openingHours
    ) {
        this.name = name;
        this.cuisineType = cuisineType;
        this.contactEmail = contactEmail;
        this.pictureUrl = pictureUrl;
        this.address = address;
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

    public ArrayList<DailyScheduleDto> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(ArrayList<DailyScheduleDto> openingHours) {
        this.openingHours = openingHours;
    }

    public String getOpeningStatusOverride() {
        return openingStatusOverride;
    }

    public void setOpeningStatusOverride(String openingStatusOverride) {
        this.openingStatusOverride = openingStatusOverride;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
