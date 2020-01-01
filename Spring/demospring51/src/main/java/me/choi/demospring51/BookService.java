package me.choi.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    List<BookRepository> bookRepository;

    public void printBookRepository() {
        this.bookRepository.forEach(System.out::println);
    }
}
