package me.choi.springinit;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SampleListener {

    public SampleListener(ApplicationArguments arguments) {
        System.out.println("foo: "+arguments.containsOption("foo"));
        System.out.println("bar: "+arguments.containsOption("bar"));
    }
}
