package com.eatexpress.app.dish.adapter.in.web.dto;

import com.eatexpress.app.common.domain.Url;
import com.eatexpress.app.dish.domain.DishAggregate;
import com.eatexpress.app.dish.domain.DishAggregate.DishUUID;
import com.eatexpress.app.dish.domain.DishAggregate.RestaurantUUID;
import com.eatexpress.app.dish.domain.DishDetails;
import com.eatexpress.app.dish.domain.FoodTag;
import com.eatexpress.app.dish.domain.Price;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DishDtoMapper {
    @Mapping(target = "name", source = "liveState.name")
    @Mapping(target = "menuNumber", source = "liveState.menuNumber")
    @Mapping(target = "type", source = "liveState")
    @Mapping(target = "description", source = "liveState.description")
    @Mapping(target = "price", source = "liveState.price")
    @Mapping(target = "foodTags", source = "liveState")
    @Mapping(target = "pictureUrl", source = "liveState.pictureUrl")
    DishDto map(DishAggregate value);

    DishDto[] map(List<DishAggregate> value);

    default String map(DishUUID value) {
        return value.uuid().toString();
    }

    default String map(RestaurantUUID value) {
        return value.uuid().toString();
    }

    default DishUUID map(String value) {
        return new DishUUID(UUID.fromString(value));
    }

    default RestaurantUUID mapRestaurantUUID(String value) {
        return new RestaurantUUID(UUID.fromString(value));
    }

    default String map(Url value) {
        return value.url();
    }

    default BigDecimal map(Price value) {
        return value.getAmount();
    }

    default ArrayList<String> map(DishDetails value) {
        ArrayList<String> foodTagsDisplayNamed = new ArrayList<>();
        for (FoodTag tag : value.getFoodTags()) {
            foodTagsDisplayNamed.add(tag.getDisplayValue());
        }
        return foodTagsDisplayNamed;
    }

    default String mapType(DishDetails value) {
        return value.getType().getDisplayValue();
    }
}
