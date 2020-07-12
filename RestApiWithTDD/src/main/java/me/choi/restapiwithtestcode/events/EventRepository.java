package me.choi.restapiwithtestcode.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Project : rest-api-with-testcode
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:46 오후
 */
public interface EventRepository extends JpaRepository<Event, Integer> {

}
