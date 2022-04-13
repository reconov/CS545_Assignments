package com.waaAssig.Assignment.aspect.logger;

import com.waaAssig.Assignment.aspect.logger.service.LoggerService;
import com.waaAssig.Assignment.aspect.logger.service.exceptionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerAspect {

//    @Autowired
//    LoggerService loggerService;
//
//    @Autowired
//    com.waaAssig.Assignment.aspect.logger.service.exceptionService exceptionService;
//
//    @Pointcut("within(com.waaAssig.Assignment..*) && !within(com.waaAssig.Assignment.aspect..*)")
//    public void entireProjectPointCut(){}
//
//    @Around("entireProjectPointCut()")
//    public void methodLogger(ProceedingJoinPoint pjp) throws Throwable{
//        pjp.proceed();
//        loggerService.add(pjp);
//    }
//
//    @AfterThrowing(value = "entireProjectPointCut()", throwing = "up")
//    public void errorLog(JoinPoint jp, Throwable up){
//        exceptionService.save(jp, up);
//    }

}
