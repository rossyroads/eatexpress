package com.eatexpress.app.dish.core;

import com.eatexpress.app.dish.domain.DishAggregate;
import com.eatexpress.app.dish.domain.DishAggregate.RestaurantUUID;
import com.eatexpress.app.dish.port.in.usecase.CalculateRestaurantAveragePriceUseCase;
import com.eatexpress.app.dish.port.out.DishPort;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CalculateRestaurantAveragePriceImpl
    implements CalculateRestaurantAveragePriceUseCase {

    private final DishPort dishPort;

    public CalculateRestaurantAveragePriceImpl(DishPort dishPort) {
        this.dishPort = dishPort;
    }

    public BigDecimal calculate(RestaurantUUID uuid) {
        List<DishAggregate> dishAggregates = dishPort.findAllByRestaurant(uuid);
        Integer totalDishes = 0;
        BigDecimal totalPrice = new BigDecimal(0);
        for (DishAggregate dish : dishAggregates) {
            totalDishes++;
            totalPrice = totalPrice.add(
                dish.getLiveState().getPrice().getAmount()
            );
        }
        BigDecimal averagePrice = new BigDecimal(0);
        if (totalDishes == 0) {
            return BigDecimal.ZERO;
        } else {
            averagePrice = totalPrice.divide(
                BigDecimal.valueOf(totalDishes),
                2,
                RoundingMode.HALF_UP
            );
        }
        return averagePrice;
    }
}
