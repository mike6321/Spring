package me.choi.demoapplicationcontextexercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/02/24
 * Time : 5:59 오후
 */
public abstract class BookService {

    private SimpleConnectionMaker simpleConnectionMaker;

    public BookService() {
        simpleConnectionMaker = new SimpleConnectionMaker();
    }

    List<Book> bookList = new ArrayList<>();

    public void add (Book book) {
        simpleConnectionMaker.getConnection();

        bookList.add(book);
    }

    public Book get(String id) {
        simpleConnectionMaker.getConnection();

        for (Book book : bookList) {
            if (book.getId().equals(id))
                return book;
        }

        return null;
    }

//    abstract protected void getConnection();
}
