package com.spring.assignmentOne.aspect.logger.service;

import com.spring.assignmentOne.aspect.logger.domain.Logger;
import com.spring.assignmentOne.aspect.logger.repo.LoggerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoggerServiceImpl implements LoggerService{

    @Autowired
    LoggerRepo loggerRepo;

//    private Logger log;

//    @Override
//    public void add(ProceedingJoinPoint pjp) {
////        log.setDate(LocalDate.now());
////        log.setTime(LocalTime.now());
////        log.setOperation("Operation");
////        log.setPrinciple("Principia Matematika");
////        loggerRepo.save(log);
//        System.out.println("\nInside logger Service.");
//        if(jp != null){
//            System.out.println(jp);
//        } else{
//            System.out.println("The passed parameter is null");
//        }
//    }

    @Override
    public List<Logger> findAll() {
        return loggerRepo.findAll();
    }

}
