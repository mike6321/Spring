package me.choi.springcorereview.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:45 오후
 */
public class PrototypeTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PrototypeBean.class);

    @Test
    void singletonBeanFind() {
        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = applicationContext.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = applicationContext.getBean(PrototypeBean.class);

//        assertThat(prototypeBean1).isSameAs(prototypeBean2);
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        applicationContext.close();

        prototypeBean1.destroy();
        prototypeBean2.destroy();
    }

    // TODO: Prototype Scope 2021/02/14 1:56 오후
    /**
     * getBean 하고 init
     * getBean 하고 init
     *
     * destroy 안된다.
     * */
    @Scope("prototype")
//    @Configuration
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean destroy");
        }
    }
}
