package me.choi.springbootgettingstarted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication

@Configuration
@ComponentScan
public class SpringbootgettingstartedApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringbootgettingstartedApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run();
    }
}
