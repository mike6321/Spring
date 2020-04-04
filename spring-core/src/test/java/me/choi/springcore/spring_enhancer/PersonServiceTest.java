package me.choi.springcore.spring_enhancer;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project : spring-core
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/04
 * Time : 4:06 오후
 */
class PersonServiceTest {

    @Test
    public void CglibEx() {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((FixedValue) () -> "Hello Junwoo !!");
        PersonService personService = (PersonService) enhancer.create();

        String res = personService.sayHello(null);

        assertEquals("Hello Junwoo !!", res);
    }

    @Test
    public void CglibEx2() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {

            if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                System.out.println(method.getReturnType());
                return "Hello Junwoo!!";
            } else {
                System.out.println(method.getReturnType());
                return proxy.invokeSuper(obj, args);
            }
        });

        PersonService personService = (PersonService) enhancer.create();

        assertEquals("Hello Junwoo!!", personService.sayHello(null));
        Integer integer = personService.lengthOfName("Junwoo");

        assertEquals(6, integer);
    }

    @Test
    public void Cglib3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BeanGenerator beanGenerator = new BeanGenerator();

        beanGenerator.addProperty("name", String.class);
        Object myBean = beanGenerator.create();
        Method setter = myBean.getClass().getMethod("setName", String.class);
        setter.invoke(myBean, "operating Cglib...!");

        Method getter = myBean.getClass().getMethod("getName");
        assertEquals("operating Cglib...!", getter.invoke(myBean));

    }
}