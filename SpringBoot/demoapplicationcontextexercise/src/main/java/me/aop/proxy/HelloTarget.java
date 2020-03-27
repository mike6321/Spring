package me.aop.proxy;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/27
 * Time : 3:48 오후
 */
public class HelloTarget implements Hello{

    @Override
    public String sayHello(String name) {
        return "Hello "+name;
    }

    @Override
    public String sayHi(String name) {
        return "Hi "+name;
    }

    @Override
    public String sayThankYou(String name) {
        return "ThankYou "+name;
    }
}
