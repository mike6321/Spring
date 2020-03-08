package me.choi.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/08
 * Time : 9:41 오후
 */
@Service
public class BookService {

    BookRepository bookRepository;

    @Autowired
    public void setBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

}
