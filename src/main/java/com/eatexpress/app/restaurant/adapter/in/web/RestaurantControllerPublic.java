package com.eatexpress.app.restaurant.adapter.in.web;

import com.eatexpress.app.common.utils.EnumUtils;
import com.eatexpress.app.restaurant.domain.CuisineType;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/restaurant")
public class RestaurantControllerPublic {

    private static final Logger log = Logger.getLogger(
        RestaurantControllerPublic.class.getName()
    );

    public RestaurantControllerPublic() {}

    @GetMapping("/cuisine-types")
    public ResponseEntity<String[]> getCuisineTypes() {
        String[] cuisineTypes = EnumUtils.enumToStringArrayDisplayName(
            CuisineType.class
        );
        return ResponseEntity.status(HttpStatus.OK).body(cuisineTypes);
    }
}
