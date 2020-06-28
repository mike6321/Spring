package me.choi.eatgo.domain;

import java.util.List;

/**
 * Project : eatgo
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:00 오후
 */
public interface RestaurantRepository {
    List<Restaurant> findAll();

    Restaurant findById(Long id);

    Restaurant save(Restaurant restaurant);
}
