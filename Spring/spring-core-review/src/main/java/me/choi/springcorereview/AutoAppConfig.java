package me.choi.springcorereview;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment : ComponentScan의 스캔위치를 지정하지 않으면 @ComponentScan이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.
 * package me.choi.springcorereview;
 * Time : 11:11 오전
 */
@Configuration
@ComponentScan(
//        basePackages = "me.choi.springcorereview.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
