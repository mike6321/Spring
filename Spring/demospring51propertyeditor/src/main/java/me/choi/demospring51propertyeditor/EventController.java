package me.choi.demospring51propertyeditor;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @GetMapping("/event/{event22}")
    public String getEvent(@PathVariable Event event22 ) {

        System.out.println(event22);
        return event22.getId().toString();
    }
}
