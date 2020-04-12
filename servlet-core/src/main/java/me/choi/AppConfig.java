package me.choi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * Project : servlet-core
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/12
 * Time : 5:29 오후
 */
@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(Controller.class))
public class AppConfig {

}
