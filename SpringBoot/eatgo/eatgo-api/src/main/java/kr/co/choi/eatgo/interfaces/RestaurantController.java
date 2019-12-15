package kr.co.choi.eatgo.interfaces;

import kr.co.choi.eatgo.application.RestaurantService;
import kr.co.choi.eatgo.domin.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    /*RestaurantController에서 직접 레파지토리 객체를 생성
    * 이는 결합도가 높아지는 단점이 있음
    * 따로 의존성을 주입하는 방안으로 코딩해봅시다.*/

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/restaurants")
    public List<Restaurant> list() {



        List<Restaurant> restaurants = restaurantService.getRestaurants();

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {

        Restaurant restaurant = restaurantService.getRestaurant(id);
//
//        Restaurant restaurants = restaurantRepository.findById(id);
//
//        List<MenuItem> menuItems = menuItemRepository.findAllByRestauranId(id);
//        restaurants.setMenuItem(menuItems);

        return restaurant;


    }
}
