package me.choi.demoapplicationcontextexercise;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/08
 * Time : 2:02 오전
 */
@SpringBootTest
class BookServiceTest {

    @Autowired
    AutoService autoService;

    @Test
    void di_Test() {
        assertNotNull(autoService);
    }

}