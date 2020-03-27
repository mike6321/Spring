package me.aop.proxy;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/27
 * Time : 9:56 오후
 */
public class HelloUppercase implements Hello{
    Hello hello;

    public HelloUppercase(Hello hello) {
        this.hello = hello;
    }


    @Override
    public String sayHello(String name) {
        return this.hello.sayHello(name).toUpperCase();
    }

    @Override
    public String sayHi(String name) {
        return this.hello.sayHi(name).toUpperCase();
    }

    @Override
    public String sayThankYou(String name) {
        return this.hello.sayThankYou(name).toUpperCase();
    }
}
