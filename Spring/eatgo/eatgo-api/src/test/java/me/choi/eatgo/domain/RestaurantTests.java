package me.choi.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Project : eatgo
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:47 오후
 */
public class RestaurantTests {

    @Test
    public void creation() {
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Suweon");
        assertThat(restaurant.getName(), is("Bob zip"));
        assertThat(restaurant.getAddress(),is("Suweon"));
        assertThat(restaurant.getId(), is(1004L));

    }

    @Test
    public void information() {
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");
        assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));

    }

}