package com.spring.assignmentOne.aspect.logger;

import com.spring.assignmentOne.aspect.logger.domain.exception;
import com.spring.assignmentOne.aspect.logger.service.LoggerService;
import com.spring.assignmentOne.aspect.logger.service.exceptionService;
import net.bytebuddy.asm.Advice;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;


@Aspect
@Component
public class LoggerAspect {

    @Autowired
    LoggerService loggerService;

    @Autowired
    exceptionService exceptionService;

    @Pointcut("within(com.spring.assignmentOne..*) && !within(com.spring.assignmentOne.aspect..*)")
    public void entireProjectPointCut(){}

    @Around("entireProjectPointCut()")
    public void methodLogger(ProceedingJoinPoint pjp) throws Throwable{
        pjp.proceed();
        loggerService.add(pjp);
    }

    @AfterThrowing(value = "entireProjectPointCut()", throwing = "up")
    public void errorLog(JoinPoint jp, Throwable up){
        exceptionService.save(jp, up);
    }

}
