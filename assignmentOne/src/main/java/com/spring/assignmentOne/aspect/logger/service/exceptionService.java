package com.spring.assignmentOne.aspect.logger.service;

import com.spring.assignmentOne.aspect.logger.domain.exception;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;

@Service
public interface exceptionService {

    void save(JoinPoint jp, Throwable throwable);

}
