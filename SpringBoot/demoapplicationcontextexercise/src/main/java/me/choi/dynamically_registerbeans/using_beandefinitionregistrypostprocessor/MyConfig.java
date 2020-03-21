package me.choi.dynamically_registerbeans.using_beandefinitionregistrypostprocessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/21
 * Time : 6:56 오후
 */
@Configuration
public class MyConfig {
    @Bean
    MyConfiguration myConfiguration () {
        return new MyConfiguration();
    }

}
