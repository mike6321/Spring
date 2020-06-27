package me.choi.eatgo.interfaces;

import me.choi.eatgo.application.RestaurantService;
import me.choi.eatgo.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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


    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/restaurant")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        return restaurants;
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {

        Restaurant restaurant = restaurantService.getRestaurant(id);

        return restaurant;
    }

    @PostMapping("/restaurant")
    public ResponseEntity<?> Create(@RequestBody Restaurant resource) throws URISyntaxException {
        String name = resource.getName();//"BeRyong";
        String address = resource.getAddress();//"Seoul";

        Restaurant restaurant = new Restaurant(1234L, name, address);;
        restaurantService.addRestaurant(restaurant);

        //URI location = new URI("/restaurant/1234");
        URI location = new URI("/restaurant/"+restaurant.getId());

        return ResponseEntity.created(location).body("{}");
    }
//    public String Create() {
//        return "";
//    }


}
