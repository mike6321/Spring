package me.choi.implicit_constructor_injection;

import me.choi.implicit_constructor_injection.client.OrderServiceClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/18
 * Time : 11:49 오후
 */
@Configuration
@ComponentScan({"me.choi.implicit_constructor_injection.client", "me.choi.implicit_constructor_injection.service"})
public class AppRunnerImplicitConstructor {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppRunnerImplicitConstructor.class);

        OrderServiceClient bean = context.getBean(OrderServiceClient.class);
        bean.showPendingOrderDetails();
    }
}
