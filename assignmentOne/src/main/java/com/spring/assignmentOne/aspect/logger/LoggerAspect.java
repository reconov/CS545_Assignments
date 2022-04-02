package com.spring.assignmentOne.aspect.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalTime;

@Aspect
@Component
public class LoggerAspect {

    @Around("@annotation(ExcutionTime)")
    public void timeLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LocalTime beforeExcution = LocalTime.now();
        proceedingJoinPoint.proceed();
        LocalTime afterExcution = LocalTime.now();

        System.out.println("|||**  Excution time details  **|||"
                +beforeExcution + "\n"
                + afterExcution
                + "\n" + "Time elapsed while excuting -->> " + proceedingJoinPoint.getSignature().getName() + " <<-- in ms : ");
        System.out.println(Duration.between(beforeExcution, afterExcution).toMillis() + "ms");
    }

}
