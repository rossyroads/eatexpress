package com.eatexpress.app.restaurant.adapter.out.db;

import com.eatexpress.app.restaurant.domain.Restaurant;
import com.eatexpress.app.restaurant.port.out.RestaurantCreatePort;
import org.springframework.stereotype.Repository;

@Repository
public class DBAdapter implements RestaurantCreatePort {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantJpaMapper restaurantJpaMapper;
    private final DailyScheduleRepository dailyScheduleRepository;

    public DBAdapter(
        RestaurantRepository restaurantRepository,
        RestaurantJpaMapper restaurantJpaMapper,
        DailyScheduleRepository dailyScheduleRepository
    ) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantJpaMapper = restaurantJpaMapper;
        this.dailyScheduleRepository = dailyScheduleRepository;
    }

    public void createRestaurant(Restaurant restaurant) {
        RestaurantJpaEntity restaurantJpaEntity = restaurantJpaMapper.map(
            restaurant
        );

        restaurantRepository.save(restaurantJpaEntity);

        for (DailyScheduleJpaEntity dailyScheduleJpaEntity : restaurantJpaEntity.getOpeningHours()) {
            dailyScheduleJpaEntity.setRestaurant(restaurantJpaEntity);
            dailyScheduleRepository.save(dailyScheduleJpaEntity);
        }
    }
}
