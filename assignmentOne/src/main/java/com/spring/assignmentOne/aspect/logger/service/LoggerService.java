package com.spring.assignmentOne.aspect.logger.service;

import com.spring.assignmentOne.aspect.logger.domain.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoggerService {

    default void add(ProceedingJoinPoint pjp) {
        System.out.println(pjp.getSignature().getName());
    }

    List<Logger> findAll();

}
