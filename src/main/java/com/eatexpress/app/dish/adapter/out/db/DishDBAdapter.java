package com.eatexpress.app.dish.adapter.out.db;

import com.eatexpress.app.dish.domain.DishAggregate;
import com.eatexpress.app.dish.domain.DishAggregate.DishUUID;
import com.eatexpress.app.dish.domain.DishDetails;
import com.eatexpress.app.dish.port.out.DishPort;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class DishDBAdapter implements DishPort {

    private static final Logger log = Logger.getLogger(
        DishDBAdapter.class.getName()
    );

    private final DishAggregateRepository dishAggregateRepository;
    private final DishAggregateJpaMapper dishAggregateJpaMapper;
    private final DishDetailsRepository dishDetailsRepository;
    private final DishDetailsJpaMapper dishDetailsJpaMapper;

    public DishDBAdapter(
        DishAggregateRepository dishAggregateRepository,
        DishAggregateJpaMapper dishAggregateJpaMapper,
        DishDetailsRepository dishDetailsRepository,
        DishDetailsJpaMapper dishDetailsJpaMapper
    ) {
        this.dishAggregateRepository = dishAggregateRepository;
        this.dishAggregateJpaMapper = dishAggregateJpaMapper;
        this.dishDetailsRepository = dishDetailsRepository;
        this.dishDetailsJpaMapper = dishDetailsJpaMapper;
    }

    public void save(DishAggregate dishAggregate) {
        // if (
        //     dishAggregateRepository
        //         .findById(dishAggregate.getUuid().uuid())
        //         .isPresent()
        // ) {
        //     log.info("Updating dish..");
        //     updateAggregate(dishAggregate);
        // } else {
        log.info("Creating new dish..");
        // DishDetailsJpaEntity dishDetailsJpaEntity = dishDetailsRepository.save(
        //     dishDetailsJpaMapper.map(dishAggregate.getDraftState())
        // );
        DishAggregateJpaEntity dishAggregateJpaEntity = mapToJpa(dishAggregate);
        // dishAggregateJpaEntity.setDraftState(dishDetailsJpaEntity);
        // dishAggregateJpaEntity.setLiveState(dishDetailsJpaEntity);
        // dishAggregateJpaEntity.setDraftState(null);
        dishAggregateRepository.save(dishAggregateJpaEntity);
        // }
    }

    public DishAggregate loadById(DishUUID uuid) {
        DishAggregateJpaEntity dishAggregateJpaEntity = dishAggregateRepository
            .findById(uuid.uuid())
            .orElseThrow();
        return dishAggregateJpaMapper.map(dishAggregateJpaEntity);
    }

    // @Transactional
    // private void updateAggregate(DishAggregate dishAggregate) {
    //     DishAggregateJpaEntity dishAggregateJpaEntityNEW = mapToJpa(
    //         dishAggregate
    //     );
    //     DishAggregateJpaEntity dishAggregateJpaEntityOLD =
    //         dishAggregateRepository
    //             .findById(dishAggregate.getUuid().uuid())
    //             .orElseThrow();
    //     log.info("Updating dish: " + dishAggregateJpaEntityNEW.getLiveStatus());
    //     dishAggregateJpaEntityOLD.setLiveStatus(
    //         dishAggregateJpaEntityNEW.getLiveStatus()
    //     );
    //     dishAggregateJpaEntityOLD.setIsOutOfStock(
    //         dishAggregateJpaEntityNEW.getIsOutOfStock()
    //     );
    //     dishAggregateJpaEntityOLD.setScheduledTime(
    //         dishAggregateJpaEntityNEW.getScheduledTime()
    //     );
    //     dishAggregateJpaEntityOLD.setVersion(
    //         dishAggregateJpaEntityOLD.getVersion() + 1
    //     );
    //     // updateDetailsIfExists(null);
    //     // dishAggregateJpaEntityOLD.setDraftState(
    //     //     dishAggregateJpaEntityNEW.getDraftState()
    //     // );
    //     // dishAggregateJpaEntityOLD.setLiveState(
    //     //     dishAggregateJpaEntityNEW.getLiveState()
    //     // );
    //     dishAggregateRepository.save(dishAggregateJpaEntityOLD);
    // }

    // private void updateOrDeleteDetailsIfExists(DishDetails dishDetails){
    //     if (dishDetails == null) {
    //         dishDetailsRepository.find
    //         updateDetails(dishAggregate.getLiveState());
    //     }
    //     if (dishAggregate.getDraftState() != null) {
    //         dishAggregateJpaEntity
    //             .getDraftState()
    //             .setDish_aggregate(dishAggregateJpaEntity);
    //     }

    // }

    // private void updateDetails(DishDetails dishDetails) {
    //     DishDetailsJpaEntity dishDetailsJpaEntityNEW = dishDetailsJpaMapper.map(
    //         dishDetails
    //     );
    //     DishDetailsJpaEntity dishDetailsJpaEntity = dishDetailsRepository
    //         .findById(dishDetails.getUuid())
    //         .orElseThrow();
    //     dishDetailsJpaEntity.setDescription(dishDetails.getDescription());
    //     dishDetailsJpaEntity.setMenuNumber(dishDetails.getMenuNumber());
    //     dishDetailsJpaEntity.setName(dishDetails.getName());
    //     dishDetailsJpaEntity.setPictureUrl(dishDetails.getPictureUrl().url());
    //     dishDetailsJpaEntity.setPrice(dishDetails.getPrice().getAmount());
    //     dishDetailsJpaEntity.setType(dishDetails.getType().toString());
    //     dishDetailsJpaEntity.setFoodTags(dishDetailsJpaEntityNEW.getFoodTags());
    //     dishDetailsRepository.save(dishDetailsJpaEntity);
    // }

    private DishAggregateJpaEntity mapToJpa(DishAggregate dishAggregate) {
        DishAggregateJpaEntity dishAggregateJpaEntity =
            dishAggregateJpaMapper.map(dishAggregate);
        // if (dishAggregate.getLiveState() != null) {
        //     dishAggregateJpaEntity
        //         .getLiveState()
        //         .setDish_aggregate(dishAggregateJpaEntity);
        // }
        // if (dishAggregate.getDraftState() != null) {
        //     dishAggregateJpaEntity
        //         .getDraftState()
        //         .setDish_aggregate(dishAggregateJpaEntity);
        // }
        return dishAggregateJpaEntity;
    }
}
