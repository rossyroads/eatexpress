package com.eatexpress.app.restaurant.adapter.in.web.dto;

import com.eatexpress.app.restaurant.domain.DailySchedule;
import java.util.ArrayList;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DailyScheduleDtoMapper {
    DailySchedule fromDto(DailyScheduleDto dailyScheduleDto);
    DailyScheduleDto toDto(DailySchedule dailySchedule);

    List<DailySchedule> mapToEntityList(
        ArrayList<DailyScheduleDto> dailyScheduleDtos
    );

    ArrayList<DailyScheduleDto> mapToDtoList(
        List<DailySchedule> dailyScheduleDtos
    );
}
