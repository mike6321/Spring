package me.whiteship.demospring51;

import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BookService {

    //@Autowired(required = false) //@Qualifier("junwooBookRepository")
    //BookRepository bookRepository;

    @Autowired
    List<BookRepository> bookRepositories;

    public void printBookRepository() {
        this.bookRepositories.forEach(System.out::println);
        //System.out.println(bookRepository.getClass());
    }

    @PostConstruct
    public void setUp() {

    }
    //둘중에서 내가 무엇을 원하는 지 스프링이 모르기때문에 에러 발생!

//    @Autowired(required = false)
    //@Autowired111
//    public void setBookRepository(BookRepository bookRepository) {
//      1 this.bookRepository = bookRepository;
//    }
    /*
     * 단순 생성자 주입인데 왜 실패일까?˜˜
     *    @Autowired
     * */

    //error가 발생했던 이유는 BookRepository에 빈이 생성되지 않았기 때문이다.ß
//    public BookService (BookRepository bookRepository){
//        this.bookRepository = bookRepository;
//    }
}
