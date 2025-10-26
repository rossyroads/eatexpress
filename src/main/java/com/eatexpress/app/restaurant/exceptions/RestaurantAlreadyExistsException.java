package com.eatexpress.app.restaurant.exceptions;

public class RestaurantAlreadyExistsException extends IllegalStateException {

    public RestaurantAlreadyExistsException() {
        super(
            "Maximum one restaurant per account reached. To manage additional restaurant please create a new account."
        );
    }
}
