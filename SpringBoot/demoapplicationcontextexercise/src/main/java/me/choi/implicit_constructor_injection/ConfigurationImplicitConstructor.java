package me.choi.implicit_constructor_injection;

import me.choi.implicit_constructor_injection.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/19
 * Time : 12:15 오전
 */
@Configuration
@ComponentScan({"me.choi.implicit_constructor_injection.client", "me.choi.implicit_constructor_injection.service"})
public class ConfigurationImplicitConstructor {
    private final OrderService orderService;

    public ConfigurationImplicitConstructor (OrderService orderService) {
        this.orderService = orderService;
    }

    @Bean(name = "services")
    public List<OrderService> services(){
        return Arrays.asList(orderService);
    }


    public static void main (String... strings) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        ConfigurationImplicitConstructor.class);
        Object services = context.getBean("services");
        System.out.println(services);
    }
}
