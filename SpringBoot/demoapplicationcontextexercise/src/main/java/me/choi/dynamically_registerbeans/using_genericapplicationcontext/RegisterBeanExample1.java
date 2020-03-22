package me.choi.dynamically_registerbeans.using_genericapplicationcontext;

import org.springframework.context.support.GenericApplicationContext;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/22
 * Time : 6:44 오후
 */
public class RegisterBeanExample1 {
    public static void main(String[] args) {
        GenericApplicationContext gac = new GenericApplicationContext();
        gac.registerBean(OrderService.OrderServiceImpl.class);
        gac.refresh();
        System.out.println("context refreshed");
        OrderService os = gac.getBean(OrderService.class);
        os.placeOrder("Laptop", 2);
        System.out.println("-----------------------------------");

        os = gac.getBean(OrderService.class);
        os.placeOrder("Desktop", 2);
        gac.close();
    }
}
