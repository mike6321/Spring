package me.choi.springcorereview.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:13 오후
 */
public class SingletonWithPrototypeTest2 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean prototypeBean1 = applicationContext.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        int count = prototypeBean1.getCount();
        assertThat(count).isEqualTo(1);

        PrototypeBean prototypeBean2 = applicationContext.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        prototypeBean2.getCount();
        count = prototypeBean2.getCount();
        assertThat(count).isEqualTo(1);
    }

    @Test
    void singletonClientUserPrototype() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = applicationContext.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);
        System.out.println("PrototypeBean의 인스턴스 : " + clientBean1.getPrototypeBean());

        ClientBean clientBean2 = applicationContext.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isNotEqualTo(2);
        System.out.println("PrototypeBean의 인스턴스 : " + clientBean2.getPrototypeBean());


        assertThat(clientBean1.getPrototypeBean()).isNotSameAs(clientBean2.getPrototypeBean());


        applicationContext.close();
    }

    // TODO: Singleton Bean 내부에 Prototype Bean을 주입받는 경우 - ObjectProvider의 사용 2021/02/14 2:53 오후
    /**
     * prototypeBeanProvider.getObject(); 를 통해 항상 새로운 프로토타입 빈이 생성
     * - 스프링컨테이너를 통해 해당 빈을 찾아서 반환
     * - 스프링이 제공하는 기능을 사용하지만 mocking이나 단위테스트에 편리하다는 장점이 있다.
     *
     * Dependency Look Up : 의존관계를 외부에서 주입 (DI) 받는 것이 아닌 필요한 의존객체를 찾는 것을 의미
     * */
    @Scope("singleton")
    static class ClientBean {

        private final ObjectProvider<PrototypeBean> prototypeBeanProvider;

        @Autowired
        public ClientBean(ObjectProvider<PrototypeBean> prototypeBeanProvider) {
            this.prototypeBeanProvider = prototypeBeanProvider;
        }

        public int logic() {
            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
            prototypeBean.addCount();

            return prototypeBean.getCount();
        }

        @PostConstruct
        public void init() {
            System.out.println("ClientBean.init " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("ClientBean.destroy " + this);
        }

        public PrototypeBean getPrototypeBean() {
            return prototypeBeanProvider.getObject();
        }
    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy " + this);
        }
    }
}
