package me.choi.restapiwithtestcode.events;

import org.springframework.hateoas.RepresentationModel;

/**
 * Project : rest-api-with-testcode
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:22 오전
 */
public class EventResource extends RepresentationModel {
    private Event event;

    public EventResource(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return this.event;
    }
}
