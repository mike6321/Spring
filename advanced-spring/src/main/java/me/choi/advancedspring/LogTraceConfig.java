package me.choi.advancedspring;

import me.choi.advancedspring.trace.logtrace.LogTrace;
import me.choi.advancedspring.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }

}
