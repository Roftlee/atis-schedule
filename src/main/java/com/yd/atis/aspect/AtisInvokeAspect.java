package com.yd.atis.aspect;

import com.yd.atis.utils.JsonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author AsiQue
 * @since :2018.02.28 11:55
 */
@Aspect
@Component
public class AtisInvokeAspect {

    private final Logger log = LoggerFactory.getLogger(AtisInvokeAspect.class);

    @Pointcut("execution(public * com.yd.atis.schedule.test.TestSchedule.*(..))")
    private void atisInvokeLogAspect() {}

    @Before(value = "atisInvokeLogAspect()")
    public void beforeAtisInvoke(JoinPoint joinPoint) {
        log.info("before atis invoke, args is:" + JsonUtils.toJson(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "o", pointcut = "atisInvokeLogAspect()")
    public void afterReturningAtisInvoke(Object o) {
        log.info("after returning atis invoke, return result:" + JsonUtils.toJson(o));
    }

    @AfterThrowing(throwing = "e", pointcut = "atisInvokeLogAspect()")
    public void afterThrowingAtisInvoke(Exception e) {
        log.info("after throwing atis invoke, exception is:" + JsonUtils.toJson(e));
    }
}
