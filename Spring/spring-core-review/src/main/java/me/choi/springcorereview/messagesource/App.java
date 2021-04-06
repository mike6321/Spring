package me.choi.springcorereview.messagesource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:37 오전
 */
@Component
public class App implements ApplicationRunner {

    @Autowired
    MessageSource messageSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println(messageSource.getClass());
        while (true) {
            System.out.println(messageSource.getMessage("greeting", new String[]{"junwoo"}, Locale.KOREA));
            System.out.println(messageSource.getMessage("greeting", new String[]{"junwoo"}, Locale.US));
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
