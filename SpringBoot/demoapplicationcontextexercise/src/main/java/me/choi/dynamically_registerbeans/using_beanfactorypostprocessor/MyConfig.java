package me.choi.dynamically_registerbeans.using_beanfactorypostprocessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/20
 * Time : 12:09 오전
 */
@Configuration
public class MyConfig {
    @Bean
    MyConfigBean myConfigBean() {
        return new MyConfigBean();
    }
}
