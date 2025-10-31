package com.eatexpress.app.pricerange.port.out;

import com.eatexpress.app.pricerange.domain.PriceRange;
import java.util.UUID;

public interface FindPriceRangePort {
    PriceRange findPriceRangeByRestaurant(UUID uuid);
}
