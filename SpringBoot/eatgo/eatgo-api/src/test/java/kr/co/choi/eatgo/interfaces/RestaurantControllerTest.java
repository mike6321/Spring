package kr.co.choi.eatgo.interfaces;

import kr.co.choi.eatgo.application.RestaurantService;
import kr.co.choi.eatgo.domin.MenuItem;
import kr.co.choi.eatgo.domin.Restaurant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@ExtendWith({SpringExtension.class})
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private RestaurantService restaurantService;

//    @SpyBean(RestaurantService.class)
//    private RestaurantService restaurantService;
//
//    @SpyBean
//    private RestaurantRepositoryImpl restaurantRepositoryImpl;
//    @SpyBean
//    private MenuItemRepositoryImpl menuItemRepository;

    @Test
    public void list() throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();
        //restaurants.add(new Restaurant(1004L, "bob zip~","Seoul"));
        restaurants.add(new Restaurant(1004L, "bob zip1212~","Seoul"));
        given(restaurantService.getRestaurants()).willReturn(restaurants);


        mvc.perform(get("/restaurants"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"name\":\"bob zip1212~\"")))
                .andExpect(content().string(
                    containsString("\"id\":1004")));

    }

    @Test
    public void detail() throws Exception {
        Restaurant restaurant = new Restaurant(1004L, "bob zip1212~", "Seoul");
        Restaurant restaurant1 = restaurant;
        given(restaurantService.getRestaurant(1004L)).willReturn(restaurant1);

        Restaurant restaurant2 = new Restaurant(2020L, "Cyber Food","Seoul");
        restaurant2.addMenuItem(new MenuItem("Kimchi"));
        given(restaurantService.getRestaurant(2020L)).willReturn(restaurant2);

        mvc.perform(get("/restaurants/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"name\":\"bob zip1212~\"")))
                .andExpect(content().string(
                        containsString("\"id\":1004")));

        mvc.perform(get("/restaurants/2020"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"name\":\"Cyber Food\"")))
                .andExpect(content().string(
                        containsString("\"id\":2020")))
                .andExpect(content().string(
                        containsString("Kimchi")
                ));
    }

}