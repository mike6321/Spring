package me.choi;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Project : Uwahan-spring-boot
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:25 오후
 */
@Component
@ConfigurationProperties("my")
public class MyProperties {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
