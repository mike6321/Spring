package me.choi.advancedspring.trace.threadlocal;

import lombok.extern.slf4j.Slf4j;
import me.choi.advancedspring.trace.threadlocal.code.FieldService;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void field() {
        log.info("main start");
        Runnable userA = () -> fieldService.logic("userA");
        Runnable userB = () -> fieldService.logic("userB");

        Thread threadA = new Thread(userA);
        threadA.setName("Thread-A");

        Thread threadB = new Thread(userB);
        threadB.setName("Thread-B");

        threadA.start();
//        sleep(2000); // 동시성 문제 발생 x
        sleep(100); // 동시성 문제 발생 o
        threadB.start();

        sleep(3000);
        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
