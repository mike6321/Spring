package me.choi.demospring51applicationaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpring51ApplicationAopApplication {

    public static void main(String[] args) {

        //SpringApplication.run(DemoSpring51ApplicationAopApplication.class, args);
        SpringApplication app = new SpringApplication(DemoSpring51ApplicationAopApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

}
