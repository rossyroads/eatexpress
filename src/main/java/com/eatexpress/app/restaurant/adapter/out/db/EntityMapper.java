package com.eatexpress.app.restaurant.adapter.out.db;

import java.util.UUID;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.eatexpress.app.restaurant.domain.Restaurant;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    // @Mapping(target ="firstName", source="firstNamezzzzzzzzz")
    // RestaurantJpaEntity map(Restaurant restaurant);

    // @InheritInverseConfiguration
    // PersonDomainClass map(PersonJpaEntity personJpaEntity);



    default UUID map(Restaurant.RestaurantUUID value){
        return value.uuid();
    }

    default Restaurant.RestaurantUUID  map(UUID value){
        return new Restaurant.RestaurantUUID(value);
    }
    
}