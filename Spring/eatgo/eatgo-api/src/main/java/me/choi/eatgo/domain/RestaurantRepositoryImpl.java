package me.choi.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Project : eatgo
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 7:08 오후
 */
@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepositoryImpl() {
        restaurants.add(new Restaurant(1004L,"Bob zip", "Suweon"));
        restaurants.add(new Restaurant(2020L,"Cyber Food", "Suweon"));
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurants;
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurants.stream()
                            .filter(r -> r.getId().equals(id))
                            .findFirst()
                            .orElse(null);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        restaurant.setId(1234L);
        restaurants.add(restaurant);

        return restaurant;
    }
}
