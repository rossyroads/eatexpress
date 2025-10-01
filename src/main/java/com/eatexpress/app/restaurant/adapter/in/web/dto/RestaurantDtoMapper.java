package com.eatexpress.app.restaurant.adapter.in.web.dto;

import com.eatexpress.app.common.domain.Email;
import com.eatexpress.app.common.domain.Url;
import com.eatexpress.app.restaurant.domain.DailySchedule;
import com.eatexpress.app.restaurant.domain.OpeningHours;
import com.eatexpress.app.restaurant.domain.Restaurant;
import com.eatexpress.app.restaurant.domain.Restaurant.RestaurantUUID;
import java.util.List;
import java.util.UUID;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    uses = { DailyScheduleDtoMapper.class }
)
public interface RestaurantDtoMapper {
    // @Mapping(target = "uuid", source = "restaurantUUID")
    RestaurantDto toDto(Restaurant restaurant);

    // @InheritInverseConfiguration
    Restaurant fromDto(RestaurantDto restaurantDto);

    default UUID map(RestaurantUUID value) {
        return value.uuid();
    }

    default RestaurantUUID map(UUID value) {
        return new RestaurantUUID(value);
    }

    default String map(Email email) {
        return email.email();
    }

    default Email mapEmail(String email) {
        return new Email(email);
    }

    default String map(Url url) {
        return url.url();
    }

    default Url mapUrl(String url) {
        return new Url(url);
    }

    default List<DailySchedule> map(OpeningHours openingHours) {
        return openingHours.getOpeningHours();
    }

    default OpeningHours map(List<DailySchedule> dailySchedules) {
        return new OpeningHours(dailySchedules);
    }
}
