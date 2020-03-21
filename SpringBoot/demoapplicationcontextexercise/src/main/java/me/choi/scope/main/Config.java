package me.choi.scope.main;

import me.choi.scope.bean.UserRegistrationBean;
import me.choi.scope.bean.UserRegistrationBeanImpl;
import me.choi.scope.bean.UserRegistrationValidator;
import me.choi.scope.service.RegistrationService;
import me.choi.scope.service.RegistrationServiceImpl;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/22
 * Time : 2:23 오전
 */
@Configuration
public class Config {

    @Bean
    public UserRegistrationValidator validator() {
        return new UserRegistrationValidator();
    }

    @Bean
    public RegistrationService registrationService() {
        return new RegistrationServiceImpl();
    }

    @Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public UserRegistrationBean userRegistrationBean() {
        return new UserRegistrationBeanImpl();
    }
}
