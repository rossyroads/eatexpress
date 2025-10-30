package com.eatexpress.app.dish.adapter.out.db;

import com.eatexpress.app.dish.domain.DishAggregate;
import com.eatexpress.app.dish.domain.DishAggregate.DishUUID;
import com.eatexpress.app.dish.domain.DishAggregate.RestaurantUUID;
import java.util.List;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    uses = { DishDetailsJpaMapper.class }
)
public interface DishAggregateJpaMapper {
    DishAggregateJpaEntity map(DishAggregate value);

    DishAggregate map(DishAggregateJpaEntity value);
    List<DishAggregate> map(List<DishAggregateJpaEntity> value);

    default UUID map(RestaurantUUID value) {
        return value.uuid();
    }

    default RestaurantUUID map(UUID value) {
        return new RestaurantUUID(value);
    }

    default UUID map(DishUUID value) {
        return value.uuid();
    }

    default DishUUID mapDishUUID(UUID value) {
        return new DishUUID(value);
    }
}
