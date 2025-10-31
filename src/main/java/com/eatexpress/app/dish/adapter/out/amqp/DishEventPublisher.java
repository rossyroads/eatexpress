package com.eatexpress.app.dish.adapter.out.amqp;

import com.eatexpress.app.common.events.RestaurantAveragePriceChangeEvent;
import com.eatexpress.app.dish.domain.DishAggregate.RestaurantUUID;
import com.eatexpress.app.dish.port.out.UpdateAveragePricePort;
import java.math.BigDecimal;
import java.util.logging.Logger;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class DishEventPublisher implements UpdateAveragePricePort {

    private static final Logger log = Logger.getLogger(
        DishEventPublisher.class.getName()
    );
    private final ApplicationEventPublisher applicationEventPublisher;

    public DishEventPublisher(
        ApplicationEventPublisher applicationEventPublisher
    ) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void update(RestaurantUUID uuid, BigDecimal averagePrice) {
        log.info("Publishing change in average price for restaurant: " + uuid);
        applicationEventPublisher.publishEvent(
            new RestaurantAveragePriceChangeEvent(uuid.uuid(), averagePrice)
        );
    }
}
