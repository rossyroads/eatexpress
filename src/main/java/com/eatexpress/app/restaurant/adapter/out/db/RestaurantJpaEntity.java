package com.eatexpress.app.restaurant.adapter.out.db;

import com.eatexpress.app.restaurant.domain.PriceRange;
import com.eatexpress.app.restaurant.domain.RestaurantStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(schema = "restaurant", name = "restaurants")
public class RestaurantJpaEntity {

    @Id
    @JdbcTypeCode(SqlTypes.CHAR)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID owner;

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
    private PriceRange priceRange;

    @OneToMany
    private List<DailyScheduleJpaEntity> openingHours;

    private RestaurantStatus openingStatusOverride;

    public RestaurantJpaEntity() {}

    public RestaurantJpaEntity(
        UUID owner,
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
        PriceRange priceRange,
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
        this.openingStatusOverride = openingStatusOverride;
    }

    public RestaurantJpaEntity(
        UUID owner,
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
        PriceRange priceRange,
        List<DailyScheduleJpaEntity> openingHours,
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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getStreet_number() {
        return street_number;
    }

    public void setStreet_number(Integer street_number) {
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

    public List<DailyScheduleJpaEntity> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(List<DailyScheduleJpaEntity> openingHours) {
        this.openingHours = openingHours;
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
