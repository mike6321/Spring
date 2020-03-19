package me.choi.autowired;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class AutowiredByName {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                            new AnnotationConfigApplicationContext(Config.class);

        ClientBean bean = context.getBean(ClientBean.class);
        bean.doSomething();

    }

    @Configuration
    public static class Config {
        @Bean(autowire = Autowire.BY_NAME)
        public ClientBean clientBean() {
            return new ClientBean();
        }

        @Bean
        public ServiceBean serviceBean01() {
            return new ServiceBean("serviceBean01");
        }

        @Bean
        public ServiceBean serviceBean02() {
            return new ServiceBean("serviceBean02");
        }
    }

    public static class ClientBean {
        @Autowired
        ServiceBean serviceBean01;

        public void doSomething() {
            System.out.println(serviceBean01.getMessage());
        }
    }

    public static class ServiceBean {
        private String message;

        public ServiceBean(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
