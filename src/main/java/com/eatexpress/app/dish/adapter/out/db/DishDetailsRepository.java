package com.eatexpress.app.dish.adapter.out.db;

import jakarta.transaction.Transactional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishDetailsRepository
    extends JpaRepository<DishDetailsJpaEntity, UUID> {
    // @Transactional
    // default DishDetailsJpaEntity updateOrInsert(DishDetailsJpaEntity entity) {
    //     return save(entity);
    // }
}
