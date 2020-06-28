package me.choi.restapiwithtestcode.events;


import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


/**
 * Project : rest-api-with-testcode
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:59 오전
 */
@Controller
@RequestMapping(value = "/api/events", produces = MediaTypes.HAL_JSON_VALUE)
public class EventController {

//    @PostMapping("/api/events")
    @PostMapping
    public ResponseEntity createEvent(@RequestBody Event event) {
//        URI createdUri = linkTo(methodOn(EventController.class).createEvent(null)).slash("{id}").toUri();
        URI createdUri = linkTo(EventController.class).slash("{id}").toUri();
        event.setId(10);
//        ResponseEntity.created(createdUri).build();
        return ResponseEntity.created(createdUri).body(event);
    }
}
