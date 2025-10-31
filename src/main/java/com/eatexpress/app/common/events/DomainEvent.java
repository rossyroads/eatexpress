package com.eatexpress.app.common.events;

import java.time.LocalDateTime;
import java.util.UUID;

public interface DomainEvent {
    LocalDateTime eventPit();

    UUID uuid();

    EventCatalog eventCatalog();
}
