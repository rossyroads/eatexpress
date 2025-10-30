package com.eatexpress.app.restaurant.adapter.out.db;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    private UUID uuid;

    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID owner;

    private String name;
    private String cuisineType;
    private String contactEmail;
    private String pictureUrl;
    private Integer defaultPreparationTimeMinutes;
    private String priceRange;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private RestaurantAddressJpaEntity address;

    @OneToMany(mappedBy = "restaurant")
    private List<DailyScheduleJpaEntity> openingHours;

    private String openingStatusOverride;

    public RestaurantJpaEntity() {}

    public RestaurantJpaEntity(UUID uuid) {
        this.uuid = uuid;
    }

    public RestaurantJpaEntity(
        UUID owner,
        String name,
        String cuisineType,
        String contactEmail,
        String pictureUrl,
        RestaurantAddressJpaEntity addressJpaEntity,
        Integer defaultPreparationTimeMinutes,
        String priceRange,
        List<DailyScheduleJpaEntity> openingHours,
        String openingStatusOverride
    ) {
        this.owner = owner;
        this.name = name;
        this.cuisineType = cuisineType;
        this.contactEmail = contactEmail;
        this.pictureUrl = pictureUrl;
        this.address = addressJpaEntity;
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

    public Integer getDefaultPreparationTimeMinutes() {
        return defaultPreparationTimeMinutes;
    }

    public void setDefaultPreparationTimeMinutes(
        Integer defaultPreparationTimeMinutes
    ) {
        this.defaultPreparationTimeMinutes = defaultPreparationTimeMinutes;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public List<DailyScheduleJpaEntity> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(List<DailyScheduleJpaEntity> openingHours) {
        this.openingHours = openingHours;
    }

    public String getOpeningStatusOverride() {
        return openingStatusOverride;
    }

    public void setOpeningStatusOverride(String openingStatusOverride) {
        this.openingStatusOverride = openingStatusOverride;
    }

    public RestaurantAddressJpaEntity getAddress() {
        return address;
    }

    public void setAddress(RestaurantAddressJpaEntity address) {
        this.address = address;
    }
}
