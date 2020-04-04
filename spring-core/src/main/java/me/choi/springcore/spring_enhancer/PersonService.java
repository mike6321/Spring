package me.choi.springcore.spring_enhancer;

/**
 * Project : spring-core
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/04
 * Time : 4:03 오후
 */
public class PersonService {
    public String sayHello(String name) {
        return "Hello" +name;
    }

    public Integer lengthOfName(String name) {
        return name.length();
    }
}
