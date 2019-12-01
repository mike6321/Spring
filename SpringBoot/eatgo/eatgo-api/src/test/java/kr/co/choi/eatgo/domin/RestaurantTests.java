package kr.co.choi.eatgo.domin;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;

class RestaurantTests {
    @Test
    public void creation() {
        Restaurant restaurant = new Restaurant("bob zip~","Seoul");
        org.hamcrest.MatcherAssert.assertThat(restaurant.getName(), is("bob zip~"));
        org.hamcrest.MatcherAssert.assertThat(restaurant.getAddress(), is("Seoul"));
    }

    @Test
    public void information() {
        Restaurant restaurant = new Restaurant("Bob zip", "SongPa");
        org.hamcrest.MatcherAssert.assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));
    }
}