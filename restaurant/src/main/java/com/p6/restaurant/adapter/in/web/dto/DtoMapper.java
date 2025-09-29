package com.eatexpress.app.restaurant.adapter.in.web.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.eatexpress.app.restaurant.domain.DailySchedule;

@Mapper(componentModel = "spring")
public interface DtoMapper {
    DtoMapper INSTANCE = Mappers.getMapper(DtoMapper.class);

    DailySchedule mapDailySchedule(DailyScheduleDto dailyScheduleDto);
    // OpeningHours mapOpeningHours(OpeningHoursDto openingHoursDto);
}
