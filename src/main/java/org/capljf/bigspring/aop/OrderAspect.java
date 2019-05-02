package org.capljf.bigspring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author jifang.liu created on 2019/5/2 16:43
 */
@Aspect
@Component
@Slf4j
@Order(2)
public class OrderAspect {

    @Pointcut("execution(* org.capljf.bigspring.controller..*.*(..))")
    public void paramCheck(){}

    @Before("paramCheck()")
    public void doBefore(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        for (Object obj:args){
            if (obj instanceof String){
                log.info("param {}'s type is right.");
            } else {
                log.error("param {}'s type is error.");
            }
        }
    }

    @AfterReturning(returning = "ret", pointcut = "paramCheck()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("order aspect");
    }
}
