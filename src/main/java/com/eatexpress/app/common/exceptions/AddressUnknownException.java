package com.eatexpress.app.common.exceptions;

public class AddressUnknownException extends IllegalArgumentException {

    public AddressUnknownException() {
        super("Address unknown");
    }
}
