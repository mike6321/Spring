package com.whiteship.demospiring51messagesource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class Demospiring51messagesourceApplication {

    public static void main(String[] args) {

        SpringApplication.run(Demospiring51messagesourceApplication.class, args);
    }
    //bean 이름은 항상 messageSource가 되어야한다.
    @Bean
    public MessageSource messageSource() {
        var messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheMillis(3);
        return messageSource;
    }

}
