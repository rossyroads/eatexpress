package com.eatexpress.app.restaurant.adapter.out.db;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyScheduleRepository
    extends JpaRepository<DailyScheduleJpaEntity, UUID> {}
