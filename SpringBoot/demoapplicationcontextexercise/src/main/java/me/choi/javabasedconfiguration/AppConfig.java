package me.choi.javabasedconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/18
 * Time : 10:54 오후
 */
@Configuration
public class AppConfig {
    @Autowired
    private DataSourceConfig dataSourceConfig;

    @Bean
    Client clientBean() {
        return new Client(dataSourceConfig.dataSourceBean());
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class, DataSourceConfig.class);
        context.getBean(Client.class).showData();
    }
}

@Configuration
class DataSourceConfig {

    @Bean
    DataSourceBean dataSourceBean() {
        return new DataSourceBean();
    }

}

class Client {
    private DataSourceBean dataSourceBean;

    public Client(DataSourceBean dataSourceBean) {
        this.dataSourceBean = dataSourceBean;
    }

    public void showData() {
        System.out.println(dataSourceBean.getData());
    }
}

class DataSourceBean {
    public String getData() {
        return "some data";
    }
}
