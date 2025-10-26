package com.eatexpress.app.restaurant.adapter.out.db;

import com.eatexpress.app.common.domain.Email;
import com.eatexpress.app.common.domain.Url;
import com.eatexpress.app.common.domain.UserId;
import com.eatexpress.app.restaurant.domain.DailySchedule;
import com.eatexpress.app.restaurant.domain.OpeningHours;
import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DailyScheduleJpaMapper {
    DailyScheduleJpaEntity map(DailySchedule dailySchedule);

    @Mapping(target = "restaurant", ignore = true)
    DailySchedule map(DailyScheduleJpaEntity dailyScheduleJpaEntity);

    List<DailySchedule> mapToEntityList(
        List<DailyScheduleJpaEntity> dailyScheduleDtos
    );

    List<DailyScheduleJpaEntity> mapToDtoList(
        List<DailySchedule> dailyScheduleDtos
    );

    default Integer map(DayOfWeek value) {
        return value.getValue();
    }

    default DayOfWeek map(Integer value) {
        return DayOfWeek.of(value);
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

    default UUID map(UserId value) {
        return value.uuid();
    }

    default UserId mapUserId(UUID value) {
        return new UserId(value);
    }
}
