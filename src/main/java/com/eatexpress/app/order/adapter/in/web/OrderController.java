package com.eatexpress.app.order.adapter.in.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.eatexpress.app.common.domain.GeocodePlace;
import com.eatexpress.app.common.service.GeocodeService;
import com.eatexpress.app.order.adapter.in.web.dto.OrderDto;
import com.eatexpress.app.order.adapter.in.web.dto.OrderDtoMapper;
import com.eatexpress.app.order.domain.Order;
import com.eatexpress.app.order.port.in.CreateOrderCommand;
import com.eatexpress.app.order.port.in.CreateOrderUseCase;
import com.eatexpress.app.restaurant.core.CreateRestaurantUseCaseImpl;
import java.net.MalformedURLException;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger log = Logger.getLogger(
        CreateRestaurantUseCaseImpl.class.getName()
    );
    private final CreateOrderUseCase createOrderUseCase;
    private final OrderDtoMapper orderDtoMapper;
    private final ObjectMapper objectMapper;
    private final GeocodeService geocodeService;

    public OrderController(
        CreateOrderUseCase createOrderUseCase,
        OrderDtoMapper orderDtoMapper,
        ObjectMapper objectMapper,
        GeocodeService geocodeService
    ) {
        this.createOrderUseCase = createOrderUseCase;
        this.orderDtoMapper = orderDtoMapper;
        this.objectMapper = objectMapper;
        this.geocodeService = geocodeService;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto)
        throws JsonProcessingException {
        log.info(
            "Received new order: " + objectMapper.writeValueAsString(orderDto)
        );
        Order order = orderDtoMapper.map(orderDto);

        try {
            GeocodePlace[] geocodeAddresses =
                geocodeService.getCoordinatesByAddress(
                    order.getContactInfo().getAddress()
                );
            if (geocodeAddresses.length == 0) return ResponseEntity.status(
                HttpStatus.BAD_REQUEST
            ).build();
            log.info(objectMapper.writeValueAsString(geocodeAddresses));
            order
                .getContactInfo()
                .getAddress()
                .setLatitude(geocodeAddresses[0].getLat());
            order
                .getContactInfo()
                .getAddress()
                .setLongitude(geocodeAddresses[0].getLon());
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        log.info("Finished");
        createOrderUseCase.handle(
            new CreateOrderCommand(
                order.getContactInfo(),
                order.getOrderedDishes(),
                order.getPayment()
            )
        );
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
