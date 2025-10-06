package com.eatexpress.app.dish.adapter.out.db;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishAggregateRepository
    extends JpaRepository<DishAggregateJpaEntity, UUID> {}
