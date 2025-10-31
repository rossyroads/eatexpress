package com.eatexpress.app.pricerange.port.in;

public interface PriceChangeProjector {
    void project(PriceChangeProjectorCommand priceChangeProjectorCommand);
}
