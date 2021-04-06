package me.choi.springcorereview.environment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:02 오전
 */
@SpringBootApplication
@PropertySource("classpath:/app.properties")
public class EnvironmentExercise {
    public static void main(String[] args) {
        SpringApplication.run(EnvironmentExercise.class, args);
    }
}
