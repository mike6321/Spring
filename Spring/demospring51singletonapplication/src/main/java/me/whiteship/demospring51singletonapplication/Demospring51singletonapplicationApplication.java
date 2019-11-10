package me.whiteship.demospring51singletonapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/app.propertes")
public class Demospring51singletonapplicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demospring51singletonapplicationApplication.class, args);
    }

}
