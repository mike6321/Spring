package me.choi.lazyloading;

import me.choi.lazyloading.bean.AlwaysBeingUsedBean;
import me.choi.lazyloading.bean.RarelyUsedBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/05
 * Time : 7:06 오후
 */
@Configuration
public class AppConfig {

    @Bean
    public AlwaysBeingUsedBean alwaysBeingUsedBean() {
        return new AlwaysBeingUsedBean();
    }

    @Bean
    @Lazy
    public RarelyUsedBean rarelyUsedBean() {
        return new RarelyUsedBean();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Spring container started and is ready");

        RarelyUsedBean bean = context.getBean(RarelyUsedBean.class);
        bean.doSomething();
    }
}
