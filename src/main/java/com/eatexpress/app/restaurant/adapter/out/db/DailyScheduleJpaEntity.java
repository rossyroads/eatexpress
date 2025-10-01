package com.eatexpress.app.restaurant.adapter.out.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalTime;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(schema = "restaurant", name = "daily_schedule")
public class DailyScheduleJpaEntity {

    @Id
    @JdbcTypeCode(SqlTypes.CHAR)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer dayOfWeek;
    private LocalTime timeFrom;
    private LocalTime timeTo;
    private boolean closedAllDay;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private RestaurantJpaEntity restaurant;

    public DailyScheduleJpaEntity() {}

    public DailyScheduleJpaEntity(
        UUID id,
        Integer dayOfWeek,
        LocalTime timeFrom,
        LocalTime timeTo,
        boolean closedAllDay,
        RestaurantJpaEntity restaurant
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

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
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

    public RestaurantJpaEntity getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantJpaEntity restaurant) {
        this.restaurant = restaurant;
    }
}
