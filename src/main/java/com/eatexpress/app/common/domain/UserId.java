package com.eatexpress.app.common.domain;

import static java.util.Objects.requireNonNull;

import java.util.UUID;
import java.util.regex.Pattern;

public record UserId(UUID uuid) {
    private static final Pattern UUID_REGEX = Pattern.compile(
        "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$"
    );

    public UserId(String s) {
        this(fromStringValidated(s));
    }

    private static UUID fromStringValidated(String s) {
        requireNonNull(s, "id must not be null");
        if (!UUID_REGEX.matcher(s).matches()) {
            throw new IllegalArgumentException("Invalid UUID format");
        }
        try {
            return UUID.fromString(s);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UUID", e);
        }
    }

    public UserId {
        requireNonNull(uuid);
    }
}
