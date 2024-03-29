package me.choi.advancedspring.trace.strategy.code.v1;

import lombok.extern.slf4j.Slf4j;
import me.choi.advancedspring.trace.strategy.code.Strategy;

/**
 * 필드에 전략을 보관하는 방식
 * */
@Slf4j
public class ContextV1 {

    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        strategy.call(); // 위임
        // 비즈니스 로직 실행
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("result Time = {}", resultTime);
    }

}
