package com.whiteship.demospiring51messagesource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    MessageSource messageSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //messageSource.getMessage("greeting", new String[] {"choi"}, Locale.KOREA);
        while (true) {
            System.out.println(messageSource.getMessage("gathering", new String[]{"choi"}, Locale.KOREA));
            System.out.println(messageSource.getMessage("greeting", new String[]{"junwoo"}, Locale.getDefault()));
            Thread.sleep(1000l);
        }
    }
}
