package me.choi.component_versus_configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/17
 * Time : 10:27 오후
 */
@SpringBootTest

class ConfigurationTest {
    @Autowired
    SimpleBeanConsumer simpleBeanConsumer;

    @Test
    public void test() {
        assertNotNull(simpleBeanConsumer);
    }

    @Configuration
    public static class Config {
        @Bean
        public SimpleBean simpleBean() {
            return new SimpleBean();
        }

        @Bean
        public SimpleBeanConsumer simpleBeanConsumer() {
            return new SimpleBeanConsumer(simpleBean());
        }
    }
}