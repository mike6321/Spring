package me.choi.springcorereview.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:18 오전
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}
