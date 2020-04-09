package me.choi.before_makingbeaninstance;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
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



    @Bean
    @Lazy
    public MyLazyBean myLazyBean() {
        return new MyLazyBean();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public MyPrototypeBean myPrototypeBean() {
        return new MyPrototypeBean();
    }
}
