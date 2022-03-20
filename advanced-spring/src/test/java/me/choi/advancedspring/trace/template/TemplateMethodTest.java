package me.choi.advancedspring.trace.template;

import lombok.extern.slf4j.Slf4j;
import me.choi.advancedspring.trace.template.code.AbstractTemplate;
import me.choi.advancedspring.trace.template.code.SubClassLogic1;
import me.choi.advancedspring.trace.template.code.SubClassLogic2;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        // 비즈니스 로직 실행
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("result Time = {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        // 비즈니스 로직 실행
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("result Time = {}", resultTime);
    }

    /**
     * 템플릿 메서드 패턴 적용
     * */
    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

}