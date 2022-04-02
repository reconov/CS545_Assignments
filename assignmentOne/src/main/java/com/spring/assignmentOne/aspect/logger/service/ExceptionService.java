package com.spring.assignmentOne.aspect.logger.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExceptionService{

    void saveException(Exception ex);

    List<Exception> findAll();

}
