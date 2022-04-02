package com.spring.assignmentOne.aspect.logger;

import com.spring.assignmentOne.aspect.logger.service.ExceptionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalTime;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    ExceptionService exceptionService;


    @Around("@annotation(ExcutionTime)")
    public void timeLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LocalTime beforeExecution = LocalTime.now();
        proceedingJoinPoint.proceed();
        LocalTime afterExecution = LocalTime.now();

        System.out.println("|||**  Execution time details  **|||"
                + "\n" + beforeExecution
                + "\n" + afterExecution
                + "\n" + "Time elapsed while executing -->> "
                + proceedingJoinPoint.getSignature().getName()
                + " <<-- in ms : ");
        System.out.println(Duration.between(beforeExecution, afterExecution).toMillis() + "ms");
    }

    @AfterThrowing( pointcut = "execution(* com.spring.assignmentOne.controller.UsersController.*(..))", throwing = "up")
    public void logExecptionsEverywhere(JoinPoint joinPoint, Throwable up){
        System.out.println("\n\n**** Exception Logged ****"
                + "\n" + joinPoint.getSignature().getName()
                + "\n" + up.getMessage()
                + "\n" + up.getStackTrace().toString());
    }

}
