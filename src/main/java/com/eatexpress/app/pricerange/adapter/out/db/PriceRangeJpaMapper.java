package com.eatexpress.app.pricerange.adapter.out.db;

import com.eatexpress.app.pricerange.domain.PriceRange;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PriceRangeJpaMapper {
    // @Mapping(source = "events", target = "eventStore")
    // PriceRange map(PriceRangeJpaEntity priceRangeJpaEntity);

    PriceRangeJpaEntity map(PriceRange priceRange);
}
