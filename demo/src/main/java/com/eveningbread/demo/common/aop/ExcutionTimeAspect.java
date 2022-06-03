package com.eveningbread.demo.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


/**
 * MemberTransactionAspect.java
 *
 * @author Nathan.Kim
 */
@Component
@Aspect
@Slf4j
public class ExcutionTimeAspect {

    @Around(value="@annotation(LogExecutionTime)") //Joinpoint 앞과 뒤에서 실행되는 Advice
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        //@LogExecutionTime 어노테이션이 붙어있는 타겟 메소드를 실행
        Object proceed = joinPoint.proceed();

        stopWatch.stop();
        log.info("time : {}", stopWatch.getLastTaskTimeMillis());
        return proceed;
    }
}
