package me.choi.demoapplicationcontextexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/08
 * Time : 1:55 오전
 */
@Component
public class AutoService {

    @Bean
    BookService bookService() {
        return new BookService();
    }

    @Bean
    AutoRepository autoRepository() {
        return new AutoRepository();
    }


}
