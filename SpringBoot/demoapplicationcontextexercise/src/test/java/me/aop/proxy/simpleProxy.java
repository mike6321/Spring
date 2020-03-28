package me.aop.proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/27
 * Time : 3:49 오후
 */
class simpleProxy {

    @Test
    public void simpleProxy3() {
        Hello proxyInstance = (Hello) Proxy.newProxyInstance(getClass().getClassLoader(),
                new Class[]{Hello.class},
                new UppercaseHandler(new HelloTarget()));
        String hello = proxyInstance.sayThankYou("Hello");
        System.out.println(hello);
    }





}