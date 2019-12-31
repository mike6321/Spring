package me.choi.springapplicationcontextexerciese;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }

//    @Bean
//    public BookService bookService() {
//        BookService bookService = new BookService();
//        bookService.setBookRepository(bookRepository());
//
//        return bookService;
//    }
    @Bean
    public BookService bookService(BookRepository bookRepository) {
        System.out.println(bookRepository);
        BookService bookService = new BookService();
        bookService.setBookRepository(bookRepository);

        return bookService;
    }
}
