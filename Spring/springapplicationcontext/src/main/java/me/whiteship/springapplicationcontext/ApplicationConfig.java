package me.whiteship.springapplicationcontext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//의존성 주입을 직접하기
@Configuration
@ComponentScan(basePackageClasses = DemoApplication.class)
//ComponentScan : 이 위치 부터 컴포넌트 스캔을 시작하세요!

public class ApplicationConfig {

//    @Bean
//    public BookRepository bookRepository(){
//
//        return new BookRepository();
//    }

//    @Bean
//    public BookService bookService(){
//        BookService bookService = new BookService();
//        bookService.setBookRepository(bookRepository());
//        return bookService;
//    }
    //파라미터로 받는 방법
//    @Bean
//    public BookService bookService(BookRepository bookRepository) {
//        BookService bookService = new BookService();
//        bookService.setBookRepository(bookRepository);
//
//        return bookService;
//    }

    //의존관계를 엮지 않아도 autowired 로 가능하다
//    @Bean
//    public BookService bookService () {
//        return new BookService();
//    }




}
