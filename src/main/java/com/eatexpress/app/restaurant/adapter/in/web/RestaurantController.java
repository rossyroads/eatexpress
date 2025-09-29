package com.eatexpress.app.restaurant.adapter.in.web;

import com.eatexpress.app.common.domain.Email;
import com.eatexpress.app.common.domain.Url;
import com.eatexpress.app.restaurant.adapter.in.web.dto.DtoMapper;
import com.eatexpress.app.restaurant.adapter.in.web.dto.RestaurantDto;
import com.eatexpress.app.restaurant.domain.CuisineType;
import com.eatexpress.app.restaurant.domain.DailySchedule;
import com.eatexpress.app.restaurant.domain.OpeningHours;
import com.eatexpress.app.restaurant.domain.Restaurant;
import com.eatexpress.app.restaurant.port.in.CreateRestaurantCommand;
import com.eatexpress.app.restaurant.port.in.CreateRestaurantUseCase;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final CreateRestaurantUseCase createRestaurantUseCase;

    // private final DtoMapper dtoMapper;

    public RestaurantController(
        CreateRestaurantUseCase createRestaurantUseCase
    ) {
        this.createRestaurantUseCase = createRestaurantUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<RestaurantDto> createRestaurant(
        @RequestBody RestaurantDto restaurantDto
    ) {
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
                new OpeningHours(null)
            );
        // DtoMapper.INSTANCE.mapOpeningHours(restaurantDto.getOpeningHours()

        Restaurant newRestaurant = createRestaurantUseCase.createRestaurant(
            createRestaurantCommand
        );

        // RestaurantDto newRestaurantDto = new RestaurantDto();

        // return ResponseEntity.status(HttpStatus.CREATED).body(newRestaurantDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantDto);
    }

    @GetMapping("/helloa")
    public void sayHelloA() {
        System.out.println("Hello BoundedContext Acdc");
    }
}
