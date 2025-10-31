package com.eatexpress.app.pricerange.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class PriceRangeNotFoundException extends EntityNotFoundException {

    public PriceRangeNotFoundException() {
        super("Price range not found!");
    }
}
