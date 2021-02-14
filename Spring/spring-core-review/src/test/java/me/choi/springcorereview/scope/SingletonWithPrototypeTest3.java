package me.choi.springcorereview.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:13 오후
 */
public class SingletonWithPrototypeTest3 {

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

    // TODO: Singleton Bean 내부에 Prototype Bean을 주입받는 경우 - JSR-330 Provider 사용 2021/02/14 3:04 오후
    /**
     * get() 메서드 하나로 기능이 매우 단순하다.
     * 별도의 라이브러리가 필요
     * 자바 표준이므로 스프링이 아닌 다른 컨테이너에서도 사용가
     *
     * 그럼 언제 JSR-330 Provider를 사용할 것인가? ObjectProvider를 사용할 것인가?
     * 스프링을 사용하다보면 이 기능 뿐만 아니라 다른 기능들도 자바 표준과 스프링이 제공하는 기능이 겹칠떄가 많이 있다.
     * 대부분 스프링이 더 다양하고 편리한 기능르 제공해주기 떄문에 특별히 다른 컨테이너를 사용할 일이 없다면 스프링이 제공하는 기능을 사용하자!
     * */
    @Scope("singleton")
    static class ClientBean {

        private final Provider<PrototypeBean> prototypeBeanProvider;

        @Autowired
        public ClientBean(Provider<PrototypeBean> prototypeBeanProvider) {
            this.prototypeBeanProvider = prototypeBeanProvider;
        }

        public int logic() {
            PrototypeBean prototypeBean = prototypeBeanProvider.get();
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
            return prototypeBeanProvider.get();
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
