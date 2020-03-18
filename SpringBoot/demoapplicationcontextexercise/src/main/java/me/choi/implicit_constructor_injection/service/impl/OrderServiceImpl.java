package me.choi.implicit_constructor_injection.service.impl;

import me.choi.implicit_constructor_injection.service.OrderService;
import org.springframework.stereotype.Component;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/18
 * Time : 11:55 오후
 */
@Component
public class OrderServiceImpl implements OrderService {
    @Override
    public String getOrderDetail(String orderId) {
        return "Order Detail from impl 1 , for order id = "+orderId;
    }
}
