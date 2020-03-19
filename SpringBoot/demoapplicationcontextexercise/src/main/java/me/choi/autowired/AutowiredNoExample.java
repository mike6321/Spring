package me.choi.autowired;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class AutowiredNoExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                            new AnnotationConfigApplicationContext(Config.class);

        ClientBean bean = context.getBean(ClientBean.class);
        bean.doSomething();

    }

    @Configuration
    public static class Config {
        @Bean(autowire = Autowire.NO)
        public ClientBean clientBean() {
            return new ClientBean();
        }

        @Bean
        public ServiceBean serviceBean01() {
            return new ServiceBean("service01");
        }

        @Bean
        public ServiceBean serviceBean02() {
            return new ServiceBean("service02");
        }
    }

    public static class ClientBean {
        @Autowired
        ServiceBean serviceBean;

        public void doSomething() {
            System.out.println(serviceBean.getMsg());
        }

    }

    public static class ServiceBean {
        private String msg;

        public ServiceBean(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }
}
