package kr.co.choi.eatgo.domin;

import java.util.List;

public interface MenuItemRepository {
    List<MenuItem> findAllByRestauranId(Long retaurantId);

}
