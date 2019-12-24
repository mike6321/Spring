package me.choi.demoaopspring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    //@Around("execution(* me.choi..*.EventService.*(..))")
    //@Around("@annotation(PerfLogging)")
    @Around("bean(simpleEventService)")
    public Object lofPerf(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis()-begin);

        return retVal;
    }

    @Before("bean(simpleEventService)")
    public void hello(){
        System.out.println("hello!!");
    }
}
