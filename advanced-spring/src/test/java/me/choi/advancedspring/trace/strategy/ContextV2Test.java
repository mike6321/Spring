package me.choi.advancedspring.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import me.choi.advancedspring.trace.strategy.code.StrategyLogic1;
import me.choi.advancedspring.trace.strategy.code.StrategyLogic2;
import me.choi.advancedspring.trace.strategy.code.v2.ContextV2;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /**
     * 전략 패턴 적용
     * */
    @Test
    void StrategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }
}
