package com.eatexpress.app.dish.domain;

import com.eatexpress.app.common.domain.Url;
import java.util.List;
import java.util.UUID;

public class DishDetails {

    private UUID uuid;

    private String name;
    private Integer menuNumber;
    private DishType type;
    private String description;
    private Price price;
    private List<FoodTag> foodTags;
    private Url pictureUrl;

    public DishDetails(
        UUID uuid,
        String name,
        Integer menuNumber,
        DishType type,
        String description,
        Price price,
        List<FoodTag> foodTags,
        Url pictureUrl
    ) {
        this.uuid = uuid;
        this.name = name;
        this.menuNumber = menuNumber;
        this.type = type;
        this.description = description;
        this.price = price;
        this.foodTags = foodTags;
        this.pictureUrl = pictureUrl;
    }

    public DishDetails() {}

    public DishDetails(String name) {
        this.name = name;
    }

    public DishDetails(
        String name,
        Integer menuNumber,
        DishType type,
        String description,
        Price price,
        List<FoodTag> foodTags,
        Url pictureUrl
    ) {
        this.name = name;
        this.menuNumber = menuNumber;
        this.type = type;
        this.description = description;
        this.price = price;
        this.foodTags = foodTags;
        this.pictureUrl = pictureUrl;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public List<FoodTag> getFoodTags() {
        return foodTags;
    }

    public void setFoodTags(List<FoodTag> foodTags) {
        this.foodTags = foodTags;
    }

    public Url getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(Url pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
