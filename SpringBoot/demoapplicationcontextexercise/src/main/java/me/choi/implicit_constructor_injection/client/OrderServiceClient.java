package me.choi.implicit_constructor_injection.client;

import me.choi.implicit_constructor_injection.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/18
 * Time : 11:52 오후
 */
@Component
public class OrderServiceClient {

    private OrderService orderService;

    public OrderServiceClient(OrderService orderService) {
        this.orderService = orderService;
    }

    public void showPendingOrderDetails() {
        System.out.println(orderService.getOrderDetail("100"));
    }
}
