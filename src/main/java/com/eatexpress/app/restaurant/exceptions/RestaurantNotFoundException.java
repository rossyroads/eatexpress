package com.eatexpress.app.restaurant.exceptions;

public class RestaurantNotFoundException extends RuntimeException {

    public RestaurantNotFoundException() {
        super("Restaurant not found!");
    }
}
