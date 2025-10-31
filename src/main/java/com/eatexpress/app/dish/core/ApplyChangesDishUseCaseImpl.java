package com.eatexpress.app.dish.core;

import com.eatexpress.app.dish.domain.DishDetails;
import com.eatexpress.app.dish.port.in.usecase.ApplyChangesDishUseCase;
import org.springframework.stereotype.Service;

@Service
public class ApplyChangesDishUseCaseImpl implements ApplyChangesDishUseCase {
    // if (dishAggregate.getLiveState() == null) {
    //         // if no live state, apply draft
    //         DishDetails dishDetails = dishAggregate.getDraftState();
    //         dishDetails.setUuid(null);
    //         dishAggregate.setLiveState(dishDetails);
    //         dishAggregate.setDraftState(null);
    //     }
}
