package me.choi.getbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/22
 * Time : 8:41 오후
 */
@Configuration
public class AnnoationConfig {

    @Bean(name = {"tiger", "kitty"})
    @Scope(value = "prototype")
    public Tiger getTiger(String name) {
        return  new Tiger(name);
    }
}
