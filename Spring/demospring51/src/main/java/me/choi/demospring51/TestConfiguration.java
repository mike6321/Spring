package me.choi.demospring51;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Project : demospring51
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 13/02/2020
 * Time : 11:21 오후
 */
@Configuration
@Profile("test")
public class TestConfiguration {
    @Bean
    public BookRepository bookRepository() {
        return new TestBookRepository();
    }
}
