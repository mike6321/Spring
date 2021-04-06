package me.choi.springcorereview.environment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:07 오전
 */
@Configuration
@Profile("test")
public class TestConfigration {
    
    // TODO: test profile일때만 등록되는 빈 설정 파일 2021/04/07 1:21 오전
    /**
     * Active profile 을 설정하거나
     * -Dspring.profiles.active="test"
     * */
    @Bean
    public BookRepository bookRepository() {
        return new TestBookRepository();
    }

}
