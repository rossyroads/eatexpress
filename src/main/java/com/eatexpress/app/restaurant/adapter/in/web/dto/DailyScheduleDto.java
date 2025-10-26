package com.eatexpress.app.restaurant.adapter.in.web.dto;

import java.time.LocalTime;

public class DailyScheduleDto {

    private String dayOfWeek;
    private LocalTime timeFrom;
    private LocalTime timeTo;
    private boolean closedAllDay;

    public DailyScheduleDto(
        String dayOfWeek,
        LocalTime timeFrom,
        LocalTime timeTo,
        boolean closedAllDay
    ) {
        this.dayOfWeek = dayOfWeek;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.closedAllDay = closedAllDay;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public LocalTime getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(LocalTime timeTo) {
        this.timeTo = timeTo;
    }

    public boolean isClosedAllDay() {
        return closedAllDay;
    }

    public void setClosedAllDay(boolean closedAllDay) {
        this.closedAllDay = closedAllDay;
    }
}
