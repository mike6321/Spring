package kr.co.choi.eatgo.application;

import kr.co.choi.eatgo.domin.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;


//@ExtendWith({SpringExtension.class})
//@WebMvcTest(RestaurantController.class)
public class RestaurantServiceTest {

    private RestaurantService restaurantService;
    @Mock
    private MenuItemRepository menuItemRepository;
    @Mock
    private RestaurantRepository restaurantRepository;



    @BeforeEach
    public void setUp() {
//        RestaurantRepository restaurantRepository = new RestaurantRepositoryImpl();
//        menuItemRepository = new MenuItemRepositoryImpl();

        mockRestaurantRepository();
        mockMenuItemRepository();
        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
    }

    private void mockMenuItemRepository() {

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Kimchi"));

        given(menuItemRepository.findAllByRestauranId(1004L)).willReturn(menuItems);

    }

    private void mockRestaurantRepository() {
        MockitoAnnotations.initMocks(this);
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1004L,"bob zip1212~","Seoul"));
        given(restaurantRepository.findAll()).willReturn(restaurants);

        given(restaurantRepository.findById(1004L)).willReturn(new Restaurant(1004L,"bob zip1212~","Seoul"));

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
