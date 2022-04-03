package com.spring.assignmentOne.aspect.logger;

import com.spring.assignmentOne.aspect.logger.service.LoggerService;
import net.bytebuddy.asm.Advice;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerAspect {

    @Autowired
    LoggerService loggerService;

    @Pointcut("within(com.spring.assignmentOne..*) && !within(com.spring.assignmentOne.aspect..*)")
    public void entireProjectPointCut(){}

    @Around("entireProjectPointCut()")
    public void methodLogger(ProceedingJoinPoint pjp) throws Throwable{
//        System.out.println(pjp.getSignature().getName());
        pjp.proceed();
        loggerService.add(pjp);
    }

}
