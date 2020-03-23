package me.aop.config;

import me.aop.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/23
 * Time : 9:53 오후
 */
public class MyApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                                    new AnnotationConfigApplicationContext(MyConfig.class);

        UserService userService = context.getBean(UserService.class);
        userService.upgradeLevels();
    }
}
