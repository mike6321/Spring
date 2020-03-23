package me.aop.config;

import me.aop.dao.UserDao;
import me.aop.service.TransactionManager;
import me.aop.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/23
 * Time : 9:39 오후
 */
@Configuration
public class MyConfig {
    @Bean
    public TransactionManager transactionManager() {
        return new TransactionManager();
    }

    @Bean
    public UserDao userDao() {
        return new UserDao();
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }

}
