package me.choi.restapi.events;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Project : rest-api
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/15
 * Time : 2:28 오후
 */
public interface EventRepository extends JpaRepository<Event, Integer> {
}
