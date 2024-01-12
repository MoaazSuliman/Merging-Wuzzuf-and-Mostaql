//package com.moaaz.wuzzufmostaql.Aspect;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//@Slf4j
//public class LoggerServiceException {
//
//
//    @Pointcut("execution(* com.moaaz.wuzzufmostaql.Servoce.Imp.*.*(..))")
//    public void forAllServiceAfterThrowing() {
//    }
//
//    @AfterThrowing(pointcut = "forAllServiceAfterThrowing()", throwing = "exception")
//    public void afterThrowingException(JoinPoint joinPoint, Throwable exception) {
//        log.info("{} For Exception {}", joinPoint.getSignature().getName(), exception.getMessage());
//    }
//}
