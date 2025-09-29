package com.eatexpress.app.common.domain;

import static java.util.Objects.requireNonNull;

public record Url(String url) {
    public Url {
        requireNonNull(url);
    }
}
