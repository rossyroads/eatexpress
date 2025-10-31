package com.eatexpress.app.pricerange.adapter.in.amqp;

import com.eatexpress.app.common.events.RestaurantAveragePriceChangeEvent;
import com.eatexpress.app.pricerange.port.in.PriceChangeProjector;
import com.eatexpress.app.pricerange.port.in.PriceChangeProjectorCommand;
import com.eatexpress.app.restaurant.domain.Restaurant.RestaurantUUID;
import java.util.logging.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PriceChangeListener {

    private static final Logger log = Logger.getLogger(
        PriceChangeListener.class.getName()
    );
    private final PriceChangeProjector priceChangeProjector;

    public PriceChangeListener(PriceChangeProjector priceChangeProjector) {
        this.priceChangeProjector = priceChangeProjector;
    }

    @EventListener(RestaurantAveragePriceChangeEvent.class)
    public void averagePriceChanged(
        RestaurantAveragePriceChangeEvent restaurantAveragePriceChangeEvent
    ) {
        log.info(
            "Received price change event for restaurant: " +
                restaurantAveragePriceChangeEvent.restaurantUUID()
        );
        priceChangeProjector.project(
            new PriceChangeProjectorCommand(
                new RestaurantUUID(
                    restaurantAveragePriceChangeEvent.restaurantUUID()
                ),
                restaurantAveragePriceChangeEvent.averagePrice()
            )
        );
    }
}
