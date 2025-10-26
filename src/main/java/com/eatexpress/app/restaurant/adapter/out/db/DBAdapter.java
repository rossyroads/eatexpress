package com.eatexpress.app.restaurant.adapter.out.db;

import com.eatexpress.app.restaurant.domain.Restaurant;
import com.eatexpress.app.restaurant.exceptions.RestaurantNotFoundException;
import com.eatexpress.app.restaurant.port.out.RestaurantCreatePort;
import com.eatexpress.app.restaurant.port.out.RestaurantFindPort;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class DBAdapter implements RestaurantCreatePort, RestaurantFindPort {

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

    public Restaurant findRestaurantByOwner(UUID ownerId) {
        List<RestaurantJpaEntity> restaurantJpaEntityList =
            restaurantRepository.findByOwner(ownerId);
        if (restaurantJpaEntityList.isEmpty()) {
            throw new RestaurantNotFoundException();
        }
        return restaurantJpaMapper.map(restaurantJpaEntityList.get(0));
    }

    public boolean checkRestaurantByOwnerExists(UUID ownerId) {
        List<RestaurantJpaEntity> restaurantJpaEntityList =
            restaurantRepository.findByOwner(ownerId);
        if (restaurantJpaEntityList.size() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
