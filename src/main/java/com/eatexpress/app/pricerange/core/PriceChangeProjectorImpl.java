package com.eatexpress.app.pricerange.core;

import com.eatexpress.app.pricerange.domain.PriceRange;
import com.eatexpress.app.pricerange.exceptions.PriceRangeNotFoundException;
import com.eatexpress.app.pricerange.port.in.PriceChangeProjector;
import com.eatexpress.app.pricerange.port.in.PriceChangeProjectorCommand;
import com.eatexpress.app.pricerange.port.out.FindPriceRangePort;
import com.eatexpress.app.pricerange.port.out.UpdatePriceRangePort;
import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class PriceChangeProjectorImpl implements PriceChangeProjector {

    private final UpdatePriceRangePort updatePriceRangePort;
    private final FindPriceRangePort findPriceRangePort;

    public PriceChangeProjectorImpl(
        UpdatePriceRangePort updatePriceRangePort,
        FindPriceRangePort findPriceRangePort
    ) {
        this.updatePriceRangePort = updatePriceRangePort;
        this.findPriceRangePort = findPriceRangePort;
    }

    public void project(
        PriceChangeProjectorCommand priceChangeProjectorCommand
    ) {
        PriceRange priceRange = findPriceRangePort.findPriceRangeByRestaurant(
            priceChangeProjectorCommand.uuid().uuid()
        );
        if (priceRange == null) {
            priceRange = new PriceRange(
                UUID.randomUUID(),
                priceChangeProjectorCommand.uuid().uuid()
            );
        }
        updateAveragePrice(
            priceRange,
            priceChangeProjectorCommand.averagePrice()
        );
    }

    private void updateAveragePrice(
        PriceRange priceRange,
        BigDecimal averagePrice
    ) {
        priceRange.changeAveragePrice(averagePrice);
        priceRange.commitEvents();
        updatePriceRangePort.save(priceRange);
    }
}
