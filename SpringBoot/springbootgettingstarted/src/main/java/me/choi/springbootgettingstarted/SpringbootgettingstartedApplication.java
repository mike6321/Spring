package me.choi.springbootgettingstarted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class SpringbootgettingstartedApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringbootgettingstartedApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }
}
