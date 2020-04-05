package me.choi.springapplicationcontextexerciese.scope.main;

import me.choi.springapplicationcontextexerciese.scope.bean.UserRegistrationBean;
import me.choi.springapplicationcontextexerciese.scope.bean.UserRegistrationBeanImpl;
import me.choi.springapplicationcontextexerciese.scope.bean.UserRegistrationValidator;
import me.choi.springapplicationcontextexerciese.scope.service.RegistrationService;
import me.choi.springapplicationcontextexerciese.scope.service.RegistrationServiceImpl;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Project : springapplicationcontextexerciese
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/22
 * Time : 12:06 오후
 */
@Configuration
public class Config {

    @Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public UserRegistrationBean userRegistrationBean() {
        return new UserRegistrationBeanImpl();
    }
    @Bean
    public UserRegistrationValidator userRegistrationValidator() {
        return new UserRegistrationValidator();
    }


    @Bean
    RegistrationService registrationService() {
        return new RegistrationServiceImpl();
    }


}
