package me.choi.springcorereview.cglib;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:01 오전
 */
public class CglibTest {
    @Test
    void cglibTest() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((FixedValue)() -> "Hello Junwoo!!");
        PersonService personService = (PersonService) enhancer.create();

        Assertions.assertThat(personService.sayHello(null)).isEqualTo("Hello Junwoo!!");
    }
}
