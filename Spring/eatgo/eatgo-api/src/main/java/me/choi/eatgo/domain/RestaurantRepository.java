package me.choi.eatgo.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Project : eatgo
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 7:08 오후
 */
public class RestaurantRepository {

    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepository() {
        restaurants.add(new Restaurant(1004L,"Bob zip", "Suweon"));
        restaurants.add(new Restaurant(2020L,"Cyber Food", "Suweon"));
    }

    public List<Restaurant> findAll() {
        return restaurants;
    }

    public Restaurant findById(Long id) {
        return restaurants.stream()
                            .filter(r -> r.getId().equals(id))
                            .findFirst()
                            .orElse(null);
    }
}
