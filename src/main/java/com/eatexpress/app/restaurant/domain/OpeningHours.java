package com.eatexpress.app.restaurant.domain;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class OpeningHours {

    private UUID id;
    private Restaurant restaurant;
    private List<DailySchedule> openingHours;

    public OpeningHours() {}

    public OpeningHours(List<DailySchedule> openingHours) {
        validateCompleteSchedule(openingHours);
        this.openingHours = openingHours;
    }

    public OpeningHours(
        Restaurant restaurant,
        List<DailySchedule> openingHours
    ) {
        validateCompleteSchedule(openingHours);
        this.restaurant = restaurant;
        this.openingHours = openingHours;
    }

    public OpeningHours(
        UUID id,
        Restaurant restaurant,
        List<DailySchedule> openingHours
    ) {
        validateCompleteSchedule(openingHours);
        this.id = id;
        this.restaurant = restaurant;
        this.openingHours = openingHours;
    }

    /**
     * Custom setter that enforces the business invariant:
     * the schedule must contain exactly one entry for all 7 days of the week.
     */
    public void setOpeningHours(List<DailySchedule> openingHours) {
        validateCompleteSchedule(openingHours);

        // Clear existing, set bidirectionality, and update the list
        this.openingHours.clear();
        for (DailySchedule schedule : openingHours) {
            this.openingHours.add(schedule);
        }
    }

    /**
     * Validation logic to ensure the schedule covers exactly 7 unique days.
     */
    private List<DailySchedule> validateCompleteSchedule(
        List<DailySchedule> schedules
    ) {
        if (schedules == null || schedules.size() != 7) {
            throw new IllegalArgumentException(
                "Restaurant must have exactly 7 daily schedule entries."
            );
        }

        Set<DayOfWeek> uniqueDays = schedules
            .stream()
            .map(DailySchedule::getDayOfWeek)
            .collect(Collectors.toSet());

        if (uniqueDays.size() != 7) {
            throw new IllegalArgumentException(
                "Schedule must include one entry for each of the 7 days of the week, with no duplicates."
            );
        }

        return schedules;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<DailySchedule> getOpeningHours() {
        return openingHours;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
