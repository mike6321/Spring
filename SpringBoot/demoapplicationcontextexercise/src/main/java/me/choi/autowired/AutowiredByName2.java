package me.choi.autowired;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class AutowiredByName2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AutowiredByName.Config.class);

        AutowiredByName.ClientBean bean = context.getBean(AutowiredByName.ClientBean.class);
        bean.doSomething();

    }

    @Configuration
    public static class Config {
        @Bean(autowire = Autowire.BY_NAME)
        public AutowiredByName.ClientBean clientBean() {
            return new AutowiredByName.ClientBean();
        }

        @Bean(name = "someOtherServiceBean")
        public AutowiredByName.ServiceBean serviceBean01() {
            return new AutowiredByName.ServiceBean("serviceBean01");
        }

        @Bean
        public AutowiredByName.ServiceBean serviceBean02() {
            return new AutowiredByName.ServiceBean("serviceBean02");
        }
    }

    public static class ClientBean {
        @Autowired
        AutowiredByName.ServiceBean someOtherServiceBean;

        public void doSomething() {
            System.out.println(someOtherServiceBean.getMessage());
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
