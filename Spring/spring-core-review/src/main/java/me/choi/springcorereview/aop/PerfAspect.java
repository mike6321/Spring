package me.choi.springcorereview.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:43 오후
 */
@Component
@Aspect
public class PerfAspect {

    @Around("execution(* me.choi.springcorereview..*.EventService.*(..))")
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();

        System.out.println(System.currentTimeMillis() - begin);

        return retVal;
    }

}
