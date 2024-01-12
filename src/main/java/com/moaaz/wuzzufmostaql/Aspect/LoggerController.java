//package com.moaaz.wuzzufmostaql.Aspect;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//@Slf4j
//public class LoggerController {
//
//    @Pointcut(value = "execution(* com.moaaz.wuzzufmostaql.Controller.*.*(..))")
//    public void afterReturnForAllControllers() {
//    }
//
//    @AfterReturning(pointcut = "afterReturnForAllControllers()", returning = "result")
//    public void afterReturnForAllControllers(JoinPoint joinPoint, Object result) {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder
//                .append("From Controller After Returning ===> ")
//                .append("Kind ==>  ")
//                .append(joinPoint.getKind())
//                .append(" Name==> ")
//                .append(joinPoint.getSignature().getName())
//                .append(" Args ==>");
//        for (Object arg : joinPoint.getArgs())
//            stringBuilder.append(arg + ", ");
//
//        log.info(stringBuilder.toString());
//    }
//
//}
