package com.eatexpress.app.restaurant.adapter.out.db;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository
    extends JpaRepository<RestaurantJpaEntity, UUID> {
    @Query(
        "select r from RestaurantJpaEntity r " +
            "left join fetch r.openingHours " +
            "where r.owner = :ownerId"
    )
    List<RestaurantJpaEntity> findByOwner(@Param("ownerId") UUID ownerId);
}
