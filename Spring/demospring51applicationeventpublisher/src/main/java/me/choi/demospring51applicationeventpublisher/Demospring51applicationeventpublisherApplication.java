package me.choi.demospring51applicationeventpublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Demospring51applicationeventpublisherApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demospring51applicationeventpublisherApplication.class, args);
    }

}
