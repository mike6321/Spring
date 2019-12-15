package kr.co.choi.eatgo.application;

import kr.co.choi.eatgo.domin.MenuItem;
import kr.co.choi.eatgo.domin.MenuItemRepository;
import kr.co.choi.eatgo.domin.Restaurant;
import kr.co.choi.eatgo.domin.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        return restaurants;
    }

    public Restaurant getRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id);
        

        List<MenuItem> menuItems = menuItemRepository.findAllByRestauranId(id);
        restaurant.setMenuItem(menuItems);

        return restaurant;
    }


}
