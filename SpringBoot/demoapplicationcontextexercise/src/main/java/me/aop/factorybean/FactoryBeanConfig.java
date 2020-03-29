package me.aop.factorybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/29
 * Time : 11:38 오전
 */
@Configuration
public class FactoryBeanConfig {

    @Bean(name = "message")
    public MessageFactoryBean messageFactoryBean() {
        MessageFactoryBean factoryBean = new MessageFactoryBean();
        factoryBean.setText("text");

        return factoryBean;
    }

    @Bean
    public Message message() throws Exception {
        return messageFactoryBean().getObject();
    }
}
