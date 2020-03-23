package me.aop.config;

import me.aop.dao.UserDao;
import me.aop.service.UserService;
import me.aop.service.UserServiceTx;
import me.aop.service.UserServiceImpl;
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
public class MyConfig  {
    @Bean
    public UserServiceTx transactionManager() {
        return new UserServiceTx();
    }

    @Bean
    public UserService userServiceImpl() {

        return new UserServiceImpl();
    }

}
