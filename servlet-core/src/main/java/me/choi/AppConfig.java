package me.choi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Project : servlet-core
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/12
 * Time : 5:29 오후
 */
@Configuration
//@ComponentScan
public class AppConfig {
    @Bean
    public HelloService helloService() {
        return new HelloService();
    }
}
