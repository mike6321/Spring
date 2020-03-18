package me.choi.demoapplicationcontextexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/02/24
 * Time : 7:34 오후
 */
@Configuration
public class BookFactory {

//    @Autowired
//    BookService bookService;

    @Bean
    public BookService bookService() {
        return new BookService(connectionMaker());
    }

    @Bean
    public AccountService accountService() {
        return new AccountService(connectionMaker());
    }
    @Bean
    public MessageService messageService() {
        return new MessageService(connectionMaker());
    }

    @Bean
    public AConnectionMaker connectionMaker() {
        return new AConnectionMaker();
    }


}
