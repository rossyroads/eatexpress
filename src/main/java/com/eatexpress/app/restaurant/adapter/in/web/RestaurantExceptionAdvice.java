package com.eatexpress.app.restaurant.adapter.in.web;

import com.eatexpress.app.restaurant.exceptions.RestaurantNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestaurantExceptionAdvice {

    @ExceptionHandler(value = { RestaurantNotFoundException.class })
    private ErrorResponse handleRestaurantNotFoundException(
        RestaurantNotFoundException ex
    ) {
        return ErrorResponse.create(
            ex,
            HttpStatus.NOT_FOUND,
            ex.getLocalizedMessage()
        );
    }
}
