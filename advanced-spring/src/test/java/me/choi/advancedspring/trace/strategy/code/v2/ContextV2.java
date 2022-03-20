package me.choi.advancedspring.trace.strategy.code.v2;

import lombok.extern.slf4j.Slf4j;
import me.choi.advancedspring.trace.strategy.code.Strategy;

/**
 * 전략을 파라미터로 전달 받는 방식
 * */
@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        strategy.call(); // 위임
        // 비즈니스 로직 실행
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("result Time = {}", resultTime);
    }

}
