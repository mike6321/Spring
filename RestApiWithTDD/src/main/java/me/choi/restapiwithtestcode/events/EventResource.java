package me.choi.restapiwithtestcode.events;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * Project : rest-api-with-testcode
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:22 오전
 */
public class EventResource extends EntityModel<Event> {

    public EventResource(Event content, Link... links) {
        super(content, links);
        add(linkTo(EventController.class).slash(content.getId()).withSelfRel());
    }
}
