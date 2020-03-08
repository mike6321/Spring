package me.choi.autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/08
 * Time : 9:44 오후
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(Main.class, args);

    }
}
