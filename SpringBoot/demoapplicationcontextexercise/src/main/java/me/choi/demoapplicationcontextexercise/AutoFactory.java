package me.choi.demoapplicationcontextexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/08
 * Time : 10:10 오전
 */
@Configuration
public class AutoFactory {


    @Bean
    public AutoService autoService() {
        return new AutoService();
    }

}
