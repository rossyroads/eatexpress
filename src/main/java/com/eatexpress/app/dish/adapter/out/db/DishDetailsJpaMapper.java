package com.eatexpress.app.dish.adapter.out.db;

import com.eatexpress.app.common.domain.Url;
import com.eatexpress.app.dish.domain.DishDetails;
import com.eatexpress.app.dish.domain.Price;
import java.math.BigDecimal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DishDetailsJpaMapper {
    DishDetails map(DishDetailsJpaEntity value);
    DishDetailsJpaEntity map(DishDetails value);

    default String map(Url value) {
        return value.url();
    }

    default Url map(String value) {
        return new Url(value);
    }

    default BigDecimal map(Price value) {
        return value.getAmount();
    }

    default Price map(BigDecimal value) {
        return new Price(value);
    }
}
