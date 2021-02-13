package me.choi.springcorereview.cglib;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:00 오전
 */
public class PersonService {
    public String sayHello(String name) {
        return "Hello" + name;
    }

    public Integer lengthOfName(String name) {
        return name.length();
    }
}
