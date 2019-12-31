package me.choi.springapplicationcontextexerciese;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }


    @Bean
    public BookService bookService(BookRepository bookRepository) {
        //@Autowired를 사용하는 방법
        return new BookService();
    }
}
