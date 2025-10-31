package com.eatexpress.app.pricerange.port.out;

import com.eatexpress.app.pricerange.domain.PriceRange;

public interface UpdatePriceRangePort {
    PriceRange save(PriceRange priceRange);
}
