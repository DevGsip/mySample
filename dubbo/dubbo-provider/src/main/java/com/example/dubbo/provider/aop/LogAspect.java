package com.example.dubbo.provider.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

//    @Pointcut("execution(* com.example.dubbo.provider.impl.*.*(..))")
//    public void doPointCut() {
//    }

//    @Around("execution(* com.example.dubbo.provider.impl.*.*(..))")
    @Around("execution(* com.example.dubbo.api.service.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            long start = System.currentTimeMillis();
            String className = joinPoint.getSignature().getDeclaringTypeName();
            String methodName = joinPoint.getSignature().getName();
            Object[] args = joinPoint.getArgs();

            result = joinPoint.proceed(args);
            long end = System.currentTimeMillis();

            log.info("接口调用：{}.{}",className,methodName);
            log.info("入参：{}",args);
            log.info("返回：{}",result);
            log.info("耗时：{}ms",end-start);
        } catch (Throwable throwable) {
            log.error("异常：",throwable);
        } finally {
            return result;
        }
    }
}
