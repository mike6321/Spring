package me.choi.eatgo.interfaces;

import me.choi.eatgo.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Project : eatgo
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:24 오후
 */
@RestController
public class RestaurantController {

    @GetMapping("/restaurant")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = new ArrayList<>();

        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Suweon");
        restaurants.add(restaurant);

        return restaurants;
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {

        List<Restaurant> restaurants = new ArrayList<>();

        restaurants.add(new Restaurant(id,"Bob zip", "Suweon"));
        restaurants.add(new Restaurant(id,"Cyber Food", "Suweon"));

        Restaurant restaurant = restaurants.stream()
                                            .filter(r -> r.getId().equals(id))
                                            .findFirst()
                                            .orElse(null);

        return restaurant;
    }

}
