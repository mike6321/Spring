package me.choi.springcorereview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCoreReviewApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringCoreReviewApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
//        SpringApplication.run(SpringCoreReviewApplication.class, args);
    }

}
