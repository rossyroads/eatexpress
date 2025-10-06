package com.eatexpress.app.dish.adapter.out.db;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(schema = "dish", name = "dish_details")
public class DishDetailsJpaEntity {

    @Id
    @JdbcTypeCode(SqlTypes.CHAR)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private String name;
    private Integer menuNumber;
    private String type;
    private String description;
    private BigDecimal price;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        schema = "dish",
        name = "food_tags",
        joinColumns = @JoinColumn(name = "dish_id")
    )
    private List<String> foodTags = new ArrayList<>();

    private String pictureUrl;

    public DishDetailsJpaEntity() {}

    public DishDetailsJpaEntity(
        UUID uuid,
        String name,
        Integer menu_number,
        String type,
        String description,
        BigDecimal price,
        List<String> foodTags,
        String pictureUrl
    ) {
        this.uuid = uuid;
        this.name = name;
        this.menuNumber = menu_number;
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

    public void setMenuNumber(Integer menu_number) {
        this.menuNumber = menu_number;
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

    public List<String> getFoodTags() {
        return foodTags;
    }

    public void setFoodTags(List<String> foodTags) {
        this.foodTags = foodTags;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
