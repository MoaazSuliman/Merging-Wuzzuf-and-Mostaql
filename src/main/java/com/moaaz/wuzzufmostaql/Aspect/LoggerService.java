//package com.moaaz.wuzzufmostaql.Aspect;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//@Slf4j
//public class LoggerService {
//
////    Logger logger= LoggerFactory.getLogger(LoggerService.class);
//
//    @Around("execution(* com.moaaz.wuzzufmostaql.Service.Developer.Imp.*.*(..))")
//    public void logTime(JoinPoint joinPoint) {
//        long startTime = System.currentTimeMillis();
//        StringBuilder stringBuilder = new StringBuilder();
//
//        stringBuilder
//                .append("Kind = ")
//                .append(joinPoint.getKind())
//                .append("    ")
//                .append("For ")
//                .append(joinPoint.getSignature())
//                .append("  ")
//                .append("Args =");
//        for (Object arg : joinPoint.getArgs()) {
//            stringBuilder.append(arg).append(", ");
//        }
////        Object result=joinPoint.proceed();
//
//        long endTime = System.currentTimeMillis();
//        stringBuilder.append(" Time To Execute Function = ")
//                .append(String.valueOf(endTime - startTime))
//                .append("MS");
//        log.info(stringBuilder.toString());
//
//    }
//
//    @Pointcut(value = "execution(* com.moaaz.wuzzufmostaql.Service.Developer.Imp.*.*(..))")
//    public void allServicePointCut() {
//    }
//    @Before(value = "allServicePointCut()")
//    public void beforeMethod(JoinPoint joinPoint) {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Before Method " + joinPoint.getSignature().getName())
//                .append(" Args ==> ");
//        for (Object arg :
//                joinPoint.getArgs()) {
//            stringBuilder.append(arg + " , ");
//        }
//        log.info(stringBuilder.toString());
//    }
//
//}
