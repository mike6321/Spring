package me.choi.demoapplicationcontextexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/02/24
 * Time : 5:59 오후
 */


public class BookService {

    @Autowired
    AutoService autoService;

    private SimpleConnectionMaker simpleConnectionMaker;

    public BookService(SimpleConnectionMaker simpleConnectionMaker) {
        simpleConnectionMaker.getConnection();
        simpleConnectionMaker = new BConnectionMaker();
    }

    List<Book> bookList = new ArrayList<>();

    public void add (Book book) {

        bookList.add(book);
    }

    public Book get(String id) {

        for (Book book : bookList) {
            if (book.getId().equals(id))
                return book;
        }

        return null;
    }

//    abstract protected void getConnection();
}
