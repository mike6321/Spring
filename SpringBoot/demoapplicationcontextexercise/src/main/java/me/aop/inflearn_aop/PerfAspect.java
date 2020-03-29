package me.aop.inflearn_aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/29
 * Time : 12:13 오전
 */
@Component
@Aspect
public class PerfAspect {


    @Around("execution(* me.aop.inflearn_aop..*.EventService.*(..))")
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();

        System.out.println(System.currentTimeMillis()-begin);
        return retVal;
    }


}
