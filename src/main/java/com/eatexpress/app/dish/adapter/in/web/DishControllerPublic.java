package com.eatexpress.app.dish.adapter.in.web;

import com.eatexpress.app.dish.adapter.in.web.dto.DishDto;
import com.eatexpress.app.dish.adapter.in.web.dto.DishDtoMapper;
import com.eatexpress.app.dish.domain.DishAggregate;
import com.eatexpress.app.dish.domain.DishAggregate.RestaurantUUID;
import com.eatexpress.app.dish.port.in.usecase.FindDishUseCase;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/dish")
public class DishControllerPublic {

    private FindDishUseCase findDishUseCase;
    private DishDtoMapper dishDtoMapper;

    public DishControllerPublic(
        FindDishUseCase findDishUseCase,
        DishDtoMapper dishDtoMapper
    ) {
        this.findDishUseCase = findDishUseCase;
        this.dishDtoMapper = dishDtoMapper;
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<DishDto[]> getAllDishes(
        @PathVariable String restaurantId
    ) {
        List<DishAggregate> dishAggregates =
            findDishUseCase.findAllByRestaurant(
                new RestaurantUUID(UUID.fromString(restaurantId))
            );
        return ResponseEntity.status(HttpStatus.OK).body(
            dishDtoMapper.map(dishAggregates)
        );
    }
}
