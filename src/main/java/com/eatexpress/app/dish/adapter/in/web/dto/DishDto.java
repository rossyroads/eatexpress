package com.eatexpress.app.dish.adapter.in.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DishDto {

    private String uuid;
    private String restaurant;
    private String liveStatus;
    private boolean isOutOfStock;
    private LocalDateTime scheduledTime = null;
    private long version;

    private String name;
    private Integer menuNumber;
    private String type;
    private String description;
    private BigDecimal price;
    private ArrayList<String> foodTags;
    private String pictureUrl;

    public DishDto() {}

    public DishDto(
        String uuid,
        String restaurant,
        String liveStatus,
        boolean isOutOfStock,
        LocalDateTime scheduledTime,
        long version,
        String name,
        Integer menuNumber,
        String type,
        String description,
        BigDecimal price,
        ArrayList<String> foodTags,
        String pictureUrl
    ) {
        this.uuid = uuid;
        this.restaurant = restaurant;
        this.liveStatus = liveStatus;
        this.isOutOfStock = isOutOfStock;
        this.scheduledTime = scheduledTime;
        this.version = version;
        this.name = name;
        this.menuNumber = menuNumber;
        this.type = type;
        this.description = description;
        this.price = price;
        this.foodTags = foodTags;
        this.pictureUrl = pictureUrl;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(String liveStatus) {
        this.liveStatus = liveStatus;
    }

    public boolean getIsOutOfStock() {
        return isOutOfStock;
    }

    public void setIsOutOfStock(boolean isOutOfStock) {
        this.isOutOfStock = isOutOfStock;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMenuNumber() {
        return menuNumber;
    }

    public void setMenuNumber(Integer menuNumber) {
        this.menuNumber = menuNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ArrayList<String> getFoodTags() {
        return foodTags;
    }

    public void setFoodTags(ArrayList<String> foodTags) {
        this.foodTags = foodTags;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
