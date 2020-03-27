package me.aop.proxy;

import org.junit.jupiter.api.Test;

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
    public void simpleProxy() {
        Hello hello = new HelloTarget();
        assertThat(hello.sayHello("Toby"), is("Hello Toby"));
    }

    @Test
    public void simpleProxy2() {
        Hello proxyHello = new HelloUppercase(new HelloTarget());
        assertThat(proxyHello.sayHello("Toby"), is("HELLO TOBY"));
    }

}