package com.eatexpress.app.dish.adapter.in.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.eatexpress.app.common.config.RabbitTopologyConfig;
import com.eatexpress.app.common.domain.Url;
import com.eatexpress.app.common.events.EventCatalog;
import com.eatexpress.app.common.events.EventHeader;
import com.eatexpress.app.common.events.EventMessage;
import com.eatexpress.app.dish.adapter.in.web.dto.DishDto;
import com.eatexpress.app.dish.domain.DishAggregate.DishUUID;
import com.eatexpress.app.dish.domain.DishAggregate.RestaurantUUID;
import com.eatexpress.app.dish.domain.DishDetails;
import com.eatexpress.app.dish.domain.DishStatus;
import com.eatexpress.app.dish.domain.DishType;
import com.eatexpress.app.dish.domain.FoodTag;
import com.eatexpress.app.dish.domain.Price;
import com.eatexpress.app.dish.port.in.command.CreateDishCommand;
import com.eatexpress.app.dish.port.in.command.StatusSetDishCommand;
import com.eatexpress.app.restaurant.core.CreateRestaurantUseCaseImpl;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dish")
public class DishController {

    private static final Logger log = Logger.getLogger(
        CreateRestaurantUseCaseImpl.class.getName()
    );
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public DishController(
        RabbitTemplate rabbitTemplate,
        ObjectMapper objectMapper
    ) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/new")
    public ResponseEntity<Void> createDish(@RequestBody DishDto dishDto)
        throws JsonProcessingException {
        log.info("Received request to create new dish: " + dishDto.getName());

        List<FoodTag> foodTags = dishDto
            .getFoodTags()
            .stream()
            .map(x -> FoodTag.valueOf(x.toUpperCase()))
            .collect(Collectors.toList());

        CreateDishCommand command = new CreateDishCommand(
            new DishUUID(UUID.randomUUID()),
            new RestaurantUUID(UUID.fromString(dishDto.getRestaurant())),
            new DishDetails(
                dishDto.getName(),
                dishDto.getMenuNumber(),
                DishType.valueOf(dishDto.getType()),
                dishDto.getDescription(),
                new Price(dishDto.getPrice()),
                foodTags,
                new Url(dishDto.getPictureUrl())
            ),
            dishDto.getIsOutOfStock()
        );

        log.info(objectMapper.writeValueAsString(command));

        EventHeader eventHeader = EventHeader.builder()
            .eventID(UUID.randomUUID())
            .eventCatalog(EventCatalog.DISH_CREATED_EVENT)
            .build();
        EventMessage eventMessage = EventMessage.builder()
            .eventHeader(eventHeader)
            .eventBody(objectMapper.writeValueAsString(command))
            .build();

        rabbitTemplate.convertAndSend(
            RabbitTopologyConfig.EVENTS_EXCHANGE_TOPIC,
            "dish.create",
            eventMessage
        );
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/{dishId}/publish")
    public ResponseEntity<Void> publishDish(@PathVariable String dishId)
        throws JsonProcessingException {
        log.info("Received request to publish dish: " + dishId);
        EventHeader eventHeader = EventHeader.builder()
            .eventID(UUID.randomUUID())
            .eventCatalog(EventCatalog.DISH_STATUS_SET_EVENT)
            .build();
        EventMessage eventMessage = EventMessage.builder()
            .eventHeader(eventHeader)
            .eventBody(
                objectMapper.writeValueAsString(
                    new StatusSetDishCommand(
                        new DishUUID(UUID.fromString(dishId)),
                        DishStatus.PUBLISHED
                    )
                )
            )
            .build();

        rabbitTemplate.convertAndSend(
            RabbitTopologyConfig.EVENTS_EXCHANGE_TOPIC,
            "dish.status.published",
            eventMessage
        );
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/{dishId}/unpublish")
    public ResponseEntity<Void> unpublishDish(@PathVariable String dishId)
        throws JsonProcessingException {
        log.info("Received request to unpublish dish: " + dishId);
        EventHeader eventHeader = EventHeader.builder()
            .eventID(UUID.randomUUID())
            .eventCatalog(EventCatalog.DISH_STATUS_SET_EVENT)
            .build();
        EventMessage eventMessage = EventMessage.builder()
            .eventHeader(eventHeader)
            .eventBody(
                objectMapper.writeValueAsString(
                    new StatusSetDishCommand(
                        new DishUUID(UUID.fromString(dishId)),
                        DishStatus.UNPUBLISHED
                    )
                )
            )
            .build();

        rabbitTemplate.convertAndSend(
            RabbitTopologyConfig.EVENTS_EXCHANGE_TOPIC,
            "dish.status.unpublished",
            eventMessage
        );
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
