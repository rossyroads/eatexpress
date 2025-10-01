package com.eatexpress.app.restaurant.adapter.in.web;

import com.eatexpress.app.common.domain.Email;
import com.eatexpress.app.common.domain.Url;
import com.eatexpress.app.restaurant.adapter.in.web.dto.DailyScheduleDtoMapper;
import com.eatexpress.app.restaurant.adapter.in.web.dto.RestaurantDto;
import com.eatexpress.app.restaurant.adapter.in.web.dto.RestaurantDtoMapper;
import com.eatexpress.app.restaurant.core.CreateRestaurantUseCaseImpl;
import com.eatexpress.app.restaurant.domain.CuisineType;
import com.eatexpress.app.restaurant.domain.OpeningHours;
import com.eatexpress.app.restaurant.domain.Restaurant;
import com.eatexpress.app.restaurant.port.in.CreateRestaurantCommand;
import com.eatexpress.app.restaurant.port.in.CreateRestaurantUseCase;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private static final Logger log = Logger.getLogger(
        CreateRestaurantUseCaseImpl.class.getName()
    );

    private final CreateRestaurantUseCase createRestaurantUseCase;

    private final DailyScheduleDtoMapper dailyScheduleDtoMapper;
    private final RestaurantDtoMapper restaurantDtoMapper;

    public RestaurantController(
        CreateRestaurantUseCase createRestaurantUseCase,
        DailyScheduleDtoMapper dailyScheduleDtoMapper,
        RestaurantDtoMapper restaurantDtoMapper
    ) {
        this.createRestaurantUseCase = createRestaurantUseCase;
        this.dailyScheduleDtoMapper = dailyScheduleDtoMapper;
        this.restaurantDtoMapper = restaurantDtoMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<RestaurantDto> createRestaurant(
        @RequestBody RestaurantDto restaurantDto
    ) {
        log.info(
            "Received request to create restaurant: " + restaurantDto.getName()
        );
        CreateRestaurantCommand createRestaurantCommand =
            new CreateRestaurantCommand(
                restaurantDto.getName(),
                CuisineType.fromDisplayName(restaurantDto.getCuisineType()),
                new Email(restaurantDto.getContactEmail()),
                new Url(restaurantDto.getPictureUrl()),
                restaurantDto.getStreet(),
                restaurantDto.getStreet_number(),
                restaurantDto.getPostalCode(),
                restaurantDto.getCity(),
                restaurantDto.getCountry(),
                restaurantDto.getDefaultPreparationTimeMinutes(),
                new OpeningHours(
                    dailyScheduleDtoMapper.mapToEntityList(
                        restaurantDto.getOpeningHours()
                    )
                )
            );

        Restaurant newRestaurant = createRestaurantUseCase.createRestaurant(
            createRestaurantCommand
        );

        RestaurantDto newRestaurantDto = restaurantDtoMapper.toDto(
            newRestaurant
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(newRestaurantDto);
    }
}
