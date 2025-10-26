package com.eatexpress.app.restaurant.adapter.out.db;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyScheduleRepository
    extends JpaRepository<DailyScheduleJpaEntity, UUID> {}
