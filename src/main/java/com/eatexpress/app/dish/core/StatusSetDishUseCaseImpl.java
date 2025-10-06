package com.eatexpress.app.dish.core;

import com.eatexpress.app.dish.domain.DishAggregate;
import com.eatexpress.app.dish.domain.DishStatus;
import com.eatexpress.app.dish.port.in.command.StatusSetDishCommand;
import com.eatexpress.app.dish.port.in.usecase.StatusSetDishUseCase;
import com.eatexpress.app.dish.port.out.DishPort;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class StatusSetDishUseCaseImpl implements StatusSetDishUseCase {

    private static final Logger log = Logger.getLogger(
        StatusSetDishUseCaseImpl.class.getName()
    );

    private final DishPort dishPort;

    public StatusSetDishUseCaseImpl(DishPort dishPort) {
        this.dishPort = dishPort;
    }

    public void handle(StatusSetDishCommand command) {
        DishAggregate dishAggregate = dishPort.loadById(command.getDishId());
        log.info("New Status: " + command.getNewStatus());
        // Check status is not the same
        if (!dishAggregate.getLiveStatus().equals(command.getNewStatus())) {
            log.info("Status not same");
            switch (command.getNewStatus()) {
                case PUBLISHED -> toPublish(dishAggregate);
                case UNPUBLISHED -> toUnpublish(dishAggregate);
            }
        }
    }

    public void toPublish(DishAggregate dishAggregate) {
        log.info("Publishing..");
        dishAggregate.setLiveStatus(DishStatus.PUBLISHED);
        dishAggregate.setScheduledTime(null);
        dishPort.save(dishAggregate);
    }

    public void toUnpublish(DishAggregate dishAggregate) {
        log.info("Unpublishing..");
        dishAggregate.setLiveStatus(DishStatus.UNPUBLISHED);
        dishAggregate.setScheduledTime(null);
        dishPort.save(dishAggregate);
    }
}
