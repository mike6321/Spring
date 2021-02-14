package me.choi.springcorereview.scope;

import org.junit.jupiter.api.Test;
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
public class SingletonWithPrototypeTest1 {

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
        assertThat(count2).isEqualTo(2);
        System.out.println("PrototypeBean의 인스턴스 : " + clientBean2.getPrototypeBean());


        assertThat(clientBean1.getPrototypeBean()).isSameAs(clientBean2.getPrototypeBean());

//        이거는 새로운 빈을 생성하기 때문에 잘못된 예시
//        PrototypeBean prototypeBean1 = applicationContext.getBean(PrototypeBean.class);
//        PrototypeBean prototypeBean2 = applicationContext.getBean(PrototypeBean.class);
//        assertThat(prototypeBean1).isSameAs(prototypeBean2);

        applicationContext.close();
    }

    // TODO: Singleton Bean 내부에 Prototype Bean을 주입받는 경우 2021/02/14 2:34 오후
    /**
     * Singleton Bean 내부에 Prototype Bean을 주입받는 경우는
     * Singleton Bean 생성 시점에 Prototype Bean의 주입이 이루어 진다.
     *
     * 그래서 이미 만들어진 Prototype Bean을 사용하게 되기 때문에
     * 위의 예제에서는 Prototype Bean 임에도 불구하고 누적된 값이 count 된다.
     *
     * 정리 : Singleton Bean이 생성됨과 동시에 Prototype Bean의 인스턴스 값을 들고 다니기 떄문이라고 결론!
     * */
    @Scope("singleton")
    static class ClientBean {
        private final PrototypeBean prototypeBean; // 생성시점에 주입이 되어버렸음

        @Autowired
        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public int logic() {
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
            return prototypeBean;
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
