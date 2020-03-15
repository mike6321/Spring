package me.choi.restapi.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * Project : rest-api
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/15
 * Time : 2:17 오전
 */
@Controller
@RequestMapping(value = "/api/events", produces = MediaTypes.HAL_JSON_VALUE)
public class EventController {

//    @Autowired
//    EventRepository eventRepository;

    private final EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    //    @PostMapping("/api/events")
    @PostMapping
    public ResponseEntity createEvent(@RequestBody Event event) {
        Event newEvent = this.eventRepository.save(event);

        URI uri = linkTo(EventController.class).slash(newEvent.getId()).toUri();
        return ResponseEntity.created(uri).body(event);
    }
}
