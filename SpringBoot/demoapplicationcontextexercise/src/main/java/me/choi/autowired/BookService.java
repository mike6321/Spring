package me.choi.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/08
 * Time : 9:41 오후
 */
@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void printBookRepository() {
        System.out.println("********************************************************");
        System.out.println(bookRepository.getClass());
        System.out.println("********************************************************");
    }

    @PostConstruct
    public void setUp() {
        System.out.println("********************************************************");
        System.out.println(bookRepository.getClass());
        System.out.println("********************************************************");
    }

}
