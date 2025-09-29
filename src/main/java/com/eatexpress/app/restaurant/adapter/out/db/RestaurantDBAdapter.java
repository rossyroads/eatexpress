package com.eatexpress.app.restaurant.adapter.out.db;

import com.eatexpress.app.restaurant.domain.DailySchedule;
import com.eatexpress.app.restaurant.domain.Restaurant;
import com.eatexpress.app.restaurant.port.out.RestaurantCreatePort;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantDBAdapter implements RestaurantCreatePort {

    private final RestaurantRepository restaurantRepository;

    public RestaurantDBAdapter(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public void createRestaurant(Restaurant restaurant) {
        RestaurantJpaEntity restaurantJpaEntity = new RestaurantJpaEntity();
        // OpeningHoursJpaEntity openingHoursJpaEntity = new OpeningHoursJpaEntity();
        // for(DailySchedule schedule : restaurant.getOpeningHours()){

        // }
        restaurantRepository.save(restaurantJpaEntity);
    }
}
