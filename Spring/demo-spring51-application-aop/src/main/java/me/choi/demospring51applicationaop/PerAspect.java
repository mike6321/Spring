package me.choi.demospring51applicationaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerAspect {

    //@Around("execution(* me.choi..*.*(..))")
    //@Around("execution(* me.choi..*.EventService.*(..))")
    @Around("@annotation(PerLogging)")
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal =  pjp.proceed();
        System.out.println(System.currentTimeMillis()-begin);
        return retVal;
    }
    @Before("bean(simpleEventService)")
    public void hello() {
        System.out.println("hola~!");
    }
}
