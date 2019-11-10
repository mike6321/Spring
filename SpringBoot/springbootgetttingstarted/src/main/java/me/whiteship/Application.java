package me.whiteship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
//스프링 "메타파일" : spring.factories
//@SpringBootConfiguration
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class,args);
        /*
        * ServletWebServerFactory bean 이 빠졌다고 나온다.
        * EnableAutoConfiguration에서 자동으로 만들어주는 bean 이다.
        * */
        //하지만 웹으로 사용할 수는 없다.
        SpringApplication application = new SpringApplication(Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);

    }
//    @Bean
//    public Holoman holoman() {
//        Holoman holoman = new Holoman();
//        holoman.setName("whiteship");
//        holoman.setHowLong(60);
//        return holoman;
//    }
}
