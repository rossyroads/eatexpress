package com.eatexpress.app.restaurant.domain;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

public class DailySchedule {

    private UUID id;
    private DayOfWeek dayOfWeek;
    private LocalTime timeFrom;
    private LocalTime timeTo;
    private boolean closedAllDay = false;
    private Restaurant restaurant;

    public DailySchedule() {}

    public DailySchedule(
        UUID id,
        DayOfWeek dayOfWeek,
        LocalTime timeFrom,
        LocalTime timeTo,
        boolean closedAllDay,
        Restaurant restaurant
    ) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.closedAllDay = closedAllDay;
        this.restaurant = restaurant;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
