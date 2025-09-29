package com.eatexpress.app.common.domain;

import static java.util.Objects.requireNonNull;

public record Email(String email) {
    public Email {
        requireNonNull(email);
    }
}
