package kr.co.choi.eatgo.interfaces;

import kr.co.choi.eatgo.domin.Restaurant;
import kr.co.choi.eatgo.domin.RestaurantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {
    private RestaurantRepository repository = new RestaurantRepository();

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
//        List<Restaurant> restaurants = new ArrayList<>();

//        Restaurant restaurant = new Restaurant(1004L,"bob zip~","Seoul");
//
//        restaurants.add(restaurant);

        List<Restaurant> restaurants = repository.findAll();

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {

//        List<Restaurant> restaurants = new ArrayList<>();
//        restaurants.add(new Restaurant(1004L,"bob zip~","Seoul"));
//        restaurants.add(new Restaurant(2020L,"Cyber Food","Seoul"));

//        List<Restaurant> restaurants = repository.findAll();
        Restaurant restaurants = repository.findById(id);

        return restaurants;

//        Restaurant restaurant = restaurants.stream()
//                .filter(r -> r.getId().equals(id))
//                .findFirst()
//                .get();

//        if(id == 1004L) {
//            restaurants = new Restaurant(1004L,"bob zip~","Seoul");
//        }
//        if(id == 2020L) {
//            restaurants = new Restaurant(2020L,"Cyber Food","Seoul");
//        }

    }
}
