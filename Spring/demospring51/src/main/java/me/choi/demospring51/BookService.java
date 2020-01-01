package me.choi.demospring51;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository junwooBookRepository;

//    public void printBookRepository() {
//        System.out.println(this.junwooBookRepository.getClass());
//    }

    @PostConstruct
    public void setUp() {
        System.out.println(this.junwooBookRepository.getClass());
    }
}
