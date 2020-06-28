package me.choi.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Project : eatgo
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:58 오후
 */
public class RestaurantRepositoryImplTest {

    RestaurantRepository restaurantRepository;

    @Test
    public void save() {
        restaurantRepository = new RestaurantRepositoryImpl();

        int oldCount = restaurantRepository.findAll().size();

        Restaurant restaurant = new Restaurant("BeRyong", "Seoul");
        restaurantRepository.save(restaurant);

        assertThat(restaurant.getId(), is(1234L));

        int newCount = restaurantRepository.findAll().size();

        assertThat(newCount - oldCount , is(1));
    }
}