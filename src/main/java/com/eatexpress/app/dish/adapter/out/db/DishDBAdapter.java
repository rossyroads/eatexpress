package com.eatexpress.app.dish.adapter.out.db;

import com.eatexpress.app.dish.domain.DishAggregate;
import com.eatexpress.app.dish.domain.DishAggregate.DishUUID;
import com.eatexpress.app.dish.domain.DishAggregate.RestaurantUUID;
import com.eatexpress.app.dish.port.out.DishPort;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class DishDBAdapter implements DishPort {

    private static final Logger log = Logger.getLogger(
        DishDBAdapter.class.getName()
    );

    private final DishAggregateRepository dishAggregateRepository;
    private final DishAggregateJpaMapper dishAggregateJpaMapper;

    public DishDBAdapter(
        DishAggregateRepository dishAggregateRepository,
        DishAggregateJpaMapper dishAggregateJpaMapper
    ) {
        this.dishAggregateRepository = dishAggregateRepository;
        this.dishAggregateJpaMapper = dishAggregateJpaMapper;
    }

    public void save(DishAggregate dishAggregate) {
        log.info("Creating new dish..");
        DishAggregateJpaEntity dishAggregateJpaEntity = mapToJpa(dishAggregate);
        dishAggregateRepository.save(dishAggregateJpaEntity);
        // }
    }

    public DishAggregate loadById(DishUUID uuid) {
        DishAggregateJpaEntity dishAggregateJpaEntity = dishAggregateRepository
            .findById(uuid.uuid())
            .orElseThrow();
        return dishAggregateJpaMapper.map(dishAggregateJpaEntity);
    }

    private DishAggregateJpaEntity mapToJpa(DishAggregate dishAggregate) {
        DishAggregateJpaEntity dishAggregateJpaEntity =
            dishAggregateJpaMapper.map(dishAggregate);
        return dishAggregateJpaEntity;
    }

    public List<DishAggregate> findAllByRestaurant(
        RestaurantUUID restaurantUUID
    ) {
        List<DishAggregateJpaEntity> dishAggregateJpaEntityList =
            dishAggregateRepository.findAllByRestaurant(restaurantUUID.uuid());
        return dishAggregateJpaMapper.map(dishAggregateJpaEntityList);
    }
}
