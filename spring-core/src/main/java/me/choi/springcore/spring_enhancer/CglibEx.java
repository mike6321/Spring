package me.choi.springcore.spring_enhancer;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;

/**
 * Project : spring-core
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/04
 * Time : 4:04 오후
 */
public class CglibEx {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((FixedValue) () -> "Hello Junwoo !!");
        PersonService personService = (PersonService) enhancer.create();

        String res = personService.sayHello(null);

    }
}
