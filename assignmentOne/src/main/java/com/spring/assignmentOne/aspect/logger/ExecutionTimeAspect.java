package com.spring.assignmentOne.aspect.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.time.Duration;
import java.time.LocalTime;

@Aspect
public class ExecutionTimeAspect {

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
                + " <<--  : ");
        System.out.println(Duration.between(beforeExecution, afterExecution).toMillis() + "ms");
    }

//    @AfterThrowing( pointcut = "execution(* com.spring.assignmentOne.controller.UsersController.*(..))", throwing = "up")
//    public void logExecptionsEverywhere(JoinPoint joinPoint, Exception up){
//        System.out.println("\n\n**** Exception Logged ****"
//                + "\n" + joinPoint.getSignature().getName()
//                + "\n" + up.getMessage()
//                + "\n" + up.getStackTrace().toString());
//        LoggerService.save(up);
//    }

}
