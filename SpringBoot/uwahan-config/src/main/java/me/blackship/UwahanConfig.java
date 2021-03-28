package me.blackship;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project : uwahan-config
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:39 오후
 */
@Configuration
public class UwahanConfig {

    @Bean
    public UwahanController uwahanController() {
        return new UwahanController();
    }

}
