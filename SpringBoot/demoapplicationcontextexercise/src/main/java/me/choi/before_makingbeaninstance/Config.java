package me.choi.before_makingbeaninstance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/22
 * Time : 9:49 오후
 */
@Configuration
//@ComponentScan
//@Component
public class Config {

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
