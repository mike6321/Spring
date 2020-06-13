package me.choi.eatgo.domain;

import me.choi.eatgo.domain.MenuItem;

import java.util.List;

/**
 * Project : eatgo
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:25 오후
 */
public interface MenuItemRepository {
    List<MenuItem> findAllByRepositoryId(Long id);
}
