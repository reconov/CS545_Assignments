package com.spring.assignmentOne.aspect.logger.service;

import com.spring.assignmentOne.aspect.logger.domain.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoggerService {

    void add(ProceedingJoinPoint pjp);

    List<Logger> findAll();

}
