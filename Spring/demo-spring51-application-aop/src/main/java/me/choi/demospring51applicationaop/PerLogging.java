package me.choi.demospring51applicationaop;

import java.lang.annotation.*;

//에노테이션 정보를 어디까지 유지할 것인가
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface PerLogging {
}
