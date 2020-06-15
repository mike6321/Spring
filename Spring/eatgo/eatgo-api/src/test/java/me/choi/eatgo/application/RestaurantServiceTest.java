package me.choi.eatgo.application;

import me.choi.eatgo.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Project : eatgo
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:45 오후
 */
//@RunWith(SpringRunner.class)
//@WebMvcTest(RestaurantController.class)
public class RestaurantServiceTest {

    private RestaurantService restaurantService;

    private MenuItemRepository menuItemRepository;

    @Before
    public void setUp() {
        restaurantService = new RestaurantService(new RestaurantRepositoryImpl(), new MenuItemRepositoryImpl());
    }

    @Test
    public void getRestaurant() {
        Restaurant restaurant = restaurantService.getRestaurant(1004L);
        assertThat(restaurant.getId(), is(1004L));

        MenuItem menuItem = restaurant.getMenuItems().get(0);
        assertThat(menuItem.getName(), is("Kimchi"));
    }

    @Test
    public void getRestaurants() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        Restaurant restaurant = restaurants.get(0);
        assertThat(restaurant.getId(),is(1004L));

    }



//    @Autowired
//    private MockMvc mvc;
//
//    @SpyBean(RestaurantRepositoryImpl.class)
//    private RestaurantRepository restaurantRepository;

//    @Test
//    public void getRestaurantMvcTest() {
//        mvc.perform(get("/restaurantService"))
//                .andExpect(status().isOk())
//                .andExpect()
//    }

}