package me.choi.springinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SampleListener implements ApplicationRunner {
    @Bean
    @ConfigurationProperties("server")
    public ServerProperties serverProperties () {
        return new ServerProperties();
    }

    @Autowired
    ChoiProperties choiProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("===========================");
        System.out.println(choiProperties.getName());
        System.out.println(choiProperties.getAge());;
        System.out.println(ServerProperties.Tomcat.Resource.class);
        System.out.println("===========================");
    }
}
