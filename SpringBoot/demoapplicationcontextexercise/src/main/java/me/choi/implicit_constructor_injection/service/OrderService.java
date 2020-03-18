package me.choi.implicit_constructor_injection.service;

import org.springframework.stereotype.Repository;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/18
 * Time : 11:53 오후
 */
public interface OrderService {
    String getOrderDetail (String orderId);
}

