package com.eatexpress.app.pricerange.adapter.out.db;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRangeRepository
    extends JpaRepository<PriceRangeJpaEntity, UUID> {}
