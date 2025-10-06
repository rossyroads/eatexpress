package com.eatexpress.app.dish.adapter.in.amqp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.eatexpress.app.common.config.RabbitTopologyConfig;
import com.eatexpress.app.common.events.EventCatalog;
import com.eatexpress.app.common.events.EventMessage;
import com.eatexpress.app.dish.port.in.command.CreateDishCommand;
import com.eatexpress.app.dish.port.in.command.StatusSetDishCommand;
import com.eatexpress.app.dish.port.in.usecase.CreateDishUseCase;
import com.eatexpress.app.dish.port.in.usecase.StatusSetDishUseCase;
import java.util.logging.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DishEventReceiver {

    private static final Logger log = Logger.getLogger(
        DishEventReceiver.class.getName()
    );

    private final ObjectMapper objectMapper;
    private final CreateDishUseCase createDishUseCase;
    private final StatusSetDishUseCase statusSetDishUseCase;

    public DishEventReceiver(
        ObjectMapper objectMapper,
        CreateDishUseCase createDishUseCase,
        StatusSetDishUseCase statusSetDishUseCase
    ) {
        this.objectMapper = objectMapper;
        this.createDishUseCase = createDishUseCase;
        this.statusSetDishUseCase = statusSetDishUseCase;
    }

    @RabbitListener(
        queues = RabbitTopologyConfig.DISH_CREATED_QUEUE,
        messageConverter = "#{jackson2JsonMessageConverter}"
    )
    public void createDish(EventMessage message)
        throws JsonProcessingException {
        log.info("Received event DISH_CREATED");
        if (
            message.getEventHeader().getEventType() ==
            EventCatalog.DISH_CREATED_EVENT
        ) {
            createDishUseCase.handle(
                objectMapper.readValue(
                    message.getEventBody(),
                    CreateDishCommand.class
                )
            );
        }
    }

    @RabbitListener(
        queues = RabbitTopologyConfig.DISH_STATUS_SET_QUEUE,
        messageConverter = "#{jackson2JsonMessageConverter}"
    )
    public void setDishStatus(EventMessage message)
        throws JsonProcessingException {
        log.info("Received event DISH_STATUS_SET");
        if (
            message.getEventHeader().getEventType() ==
            EventCatalog.DISH_STATUS_SET_EVENT
        ) {
            statusSetDishUseCase.handle(
                objectMapper.readValue(
                    message.getEventBody(),
                    StatusSetDishCommand.class
                )
            );
        }
    }
}
