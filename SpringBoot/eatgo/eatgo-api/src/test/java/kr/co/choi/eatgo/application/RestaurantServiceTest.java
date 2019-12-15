package kr.co.choi.eatgo.application;

import kr.co.choi.eatgo.domin.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;


//@ExtendWith({SpringExtension.class})
//@WebMvcTest(RestaurantController.class)
public class RestaurantServiceTest {

    private RestaurantService restaurantService;

    private MenuItemRepository menuItemRepository;

    @BeforeEach
    public void setUp() {
        RestaurantRepository restaurantRepository = new RestaurantRepositoryImpl();
        menuItemRepository = new MenuItemRepositoryImpl();

        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
    }


    @Test
    public void getRestaurant() {
        Restaurant restaurant = restaurantService.getRestaurant(1004L);
        org.hamcrest.MatcherAssert.assertThat(restaurant.getId(), is(1004L));
        MenuItem menuItem = restaurant.getMenuItems().get(0);

        org.hamcrest.MatcherAssert.assertThat(menuItem.getName(), is("Kimchi"));
    }

    @Test
    public void getRestaurants() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        Restaurant restaurant = restaurants.get(0);
        org.hamcrest.MatcherAssert.assertThat(restaurant.getId(), is(1004L));
    }

}
