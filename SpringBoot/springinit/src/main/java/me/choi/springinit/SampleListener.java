package me.choi.springinit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(SampleListener.class);

    @Autowired
    private String hello;

    @Autowired
    private ChoiProperties choiProperties;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("------------------------------");
        logger.info(hello);
        logger.info(choiProperties.getName());
        logger.info(choiProperties.getFullName());
        logger.info("------------------------------");
    }
}
