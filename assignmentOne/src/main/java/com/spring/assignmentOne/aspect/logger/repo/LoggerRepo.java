package com.spring.assignmentOne.aspect.logger.repo;

import com.spring.assignmentOne.aspect.logger.domain.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LoggerRepo extends CrudRepository<Logger, Long> {

    List<Logger> findAll();

}
