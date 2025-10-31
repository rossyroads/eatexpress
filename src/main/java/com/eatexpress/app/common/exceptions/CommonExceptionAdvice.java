package com.eatexpress.app.common.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class CommonExceptionAdvice {

    @ExceptionHandler(value = { IllegalArgumentException.class })
    private ErrorResponse handleIllegalArgumentException(
        IllegalArgumentException ex
    ) {
        return ErrorResponse.create(
            ex,
            HttpStatus.BAD_REQUEST,
            ex.getLocalizedMessage()
        );
    }

    @ExceptionHandler(value = { NullPointerException.class })
    private ErrorResponse handleNullPointerException(NullPointerException ex) {
        return ErrorResponse.create(
            ex,
            HttpStatus.BAD_REQUEST,
            ex.getLocalizedMessage()
        );
    }

    @ExceptionHandler(value = { NoResourceFoundException.class })
    private ErrorResponse handleNoResourceFoundException(
        NoResourceFoundException ex
    ) {
        return ErrorResponse.create(
            ex,
            HttpStatus.BAD_REQUEST,
            "Endpoint doesn't exist."
        );
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    private ErrorResponse handleEntityNotFoundException(
        EntityNotFoundException ex
    ) {
        return ErrorResponse.create(
            ex,
            HttpStatus.NOT_FOUND,
            ex.getLocalizedMessage()
        );
    }

    @ExceptionHandler(value = { IllegalStateException.class })
    private ErrorResponse handleIllegalStateException(
        IllegalStateException ex
    ) {
        return ErrorResponse.create(
            ex,
            HttpStatus.CONFLICT,
            ex.getLocalizedMessage()
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse handleRuntimeException(RuntimeException ex) {
        return ErrorResponse.create(
            ex,
            HttpStatus.INTERNAL_SERVER_ERROR,
            "An unexpected error occurred"
        );
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleServerError(Exception ex) {
        return ErrorResponse.create(
            ex,
            HttpStatus.INTERNAL_SERVER_ERROR,
            "An unexpected error occurred"
        );
    }
}
