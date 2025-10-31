package com.eatexpress.app.pricerange.adapter.out.db;

import com.eatexpress.app.common.events.DomainEvent;
import com.eatexpress.app.common.events.RestaurantAveragePriceChangeEvent;
import com.eatexpress.app.pricerange.domain.PriceRange;
import com.eatexpress.app.pricerange.exceptions.PriceRangeNotFoundException;
import com.eatexpress.app.pricerange.port.out.FindPriceRangePort;
import com.eatexpress.app.pricerange.port.out.UpdatePriceRangePort;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class PriceRangeDBAdapter
    implements FindPriceRangePort, UpdatePriceRangePort {

    private final PriceRangeRepository priceRangeRepository;
    private final PriceRangeJpaMapper priceRangeJpaMapper;

    public PriceRangeDBAdapter(
        PriceRangeRepository priceRangeRepository,
        PriceRangeJpaMapper priceRangeJpaMapper
    ) {
        this.priceRangeRepository = priceRangeRepository;
        this.priceRangeJpaMapper = priceRangeJpaMapper;
    }

    public PriceRange findPriceRangeByRestaurant(UUID uuid) {
        // return priceRangeJpaMapper.map(
        //     priceRangeRepository
        //         .findById(uuid)
        //         .orElseThrow(() -> new PriceRangeNotFoundException())
        //         );
        Optional<PriceRangeJpaEntity> priceRangeJpaEntity =
            priceRangeRepository.findById(uuid);
        // .orElseThrow(() -> new PriceRangeNotFoundException())
        // .orElse(null);
        if (priceRangeJpaEntity.isPresent()) {
            return priceRangeJpaEntity.get().toDomain();
        } else {
            return null;
        }
    }

    public PriceRange save(PriceRange priceRange) {
        PriceRangeJpaEntity priceRangeJpaEntity = new PriceRangeJpaEntity(
            priceRange.getId(),
            priceRange.getRestaurantUuid()
        );

        for (DomainEvent e : priceRange.getDomainEvents()) {
            priceRangeJpaEntity
                .getEvents()
                .add(mapFromDomainEvent(e, priceRangeJpaEntity));
        }
        PriceRangeJpaEntity newPriceRangeJpaEntity = priceRangeRepository.save(
            priceRangeJpaEntity
        );

        return newPriceRangeJpaEntity.toDomain();
    }

    private PriceRangeEventJpaEntity mapFromDomainEvent(
        DomainEvent domainEvent,
        PriceRangeJpaEntity priceRangeJpaEntity
    ) {
        return switch (domainEvent) {
            case RestaurantAveragePriceChangeEvent event -> new PriceRangeEventJpaEntity(
                event.uuid(),
                event.eventPit(),
                event.eventCatalog().name(),
                event.averagePrice(),
                priceRangeJpaEntity
            );
            default -> throw new IllegalArgumentException(
                "Unknown domain event type: " + domainEvent.getClass()
            );
        };
    }
}
