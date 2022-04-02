package com.spring.assignmentOne.aspect.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Pointcut("@annotation(ExcutionTime)")
    public void logMe(){}

    @Before("logMe()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("Logging out details before things excute");
    }

    @After("logMe()")
    public void logAfter(){
        System.out.println("Logging out details after excution");
    }

//    @AfterReturning
//    @Around()

}
