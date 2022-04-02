package com.spring.assignmentOne.aspect.logger.service;


import com.spring.assignmentOne.aspect.logger.repo.ExceptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExceptionServiceImpl implements ExceptionService{

    @Autowired
    ExceptionRepo exceptionRepo;

    @Override
    public void saveException(Exception ex){
        exceptionRepo.save(ex);
    }

    @Override
    public List<Exception> findAll(){
        return exceptionRepo.findAll();
    }
}
