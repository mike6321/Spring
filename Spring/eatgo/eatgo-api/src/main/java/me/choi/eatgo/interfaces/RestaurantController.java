package me.choi.eatgo.interfaces;

import me.choi.eatgo.domain.MenuItem;
import me.choi.eatgo.domain.MenuItemRepository;
import me.choi.eatgo.domain.Restaurant;
import me.choi.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Project : eatgo
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:24 오후
 */
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository repositoryRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;


    @GetMapping("/restaurant")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = repositoryRepository.findAll();

        return restaurants;
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        Restaurant restaurant= repositoryRepository.findById(id);
        List<MenuItem> menuItems = menuItemRepository.findAllByRepositoryId(id);
        restaurant.setMenuItem(menuItems);

        return restaurant;
    }

}
