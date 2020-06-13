package me.choi.eatgo.interfaces;

import me.choi.eatgo.domain.Restaurant;
import me.choi.eatgo.domain.RestaurantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Project : eatgo
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:24 오후
 */
@RestController
public class RestaurantController {

    private RestaurantRepository repository = new RestaurantRepository();

    @GetMapping("/restaurant")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = repository.findAll();

        return restaurants;
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {

        Restaurant restaurant= repository.findById(id);

//        Restaurant restaurant = restaurants.stream()
//                                            .filter(r -> r.getId().equals(id))
//                                            .findFirst()
//                                            .orElse(null);

        return restaurant;
    }

}
