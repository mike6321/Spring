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
        Restaurant restaurant = new Restaurant("Bob zip", "Suweon");
        assertThat(restaurant.getName(), is("Bob zip"));
        assertThat(restaurant.getAddress(),is("Suweon"));

    }

    @Test
    public void information() {
        Restaurant restaurant = new Restaurant("Bob zip", "Seoul");
        assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));

    }

}