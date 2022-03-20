package me.choi.advancedspring.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import me.choi.advancedspring.trace.strategy.code.strategy.ContextV1;
import me.choi.advancedspring.trace.strategy.code.strategy.StrategyLogic1;
import me.choi.advancedspring.trace.strategy.code.strategy.StrategyLogic2;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV0() {
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
     * 전략 패턴 사용
     * */
    @Test
    void strategyV1() {
        StrategyLogic1 strategy1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategy1);
        contextV1.execute();

        StrategyLogic2 strategy2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategy2);
        contextV2.execute();
    }

    @Test
    void strategyV2() {
        ContextV1 contextV1 = new ContextV1(() -> log.info("비즈니스 로직1 실행"));
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(() -> log.info("비즈니스 로직2 실행"));
        contextV2.execute();
    }

}
