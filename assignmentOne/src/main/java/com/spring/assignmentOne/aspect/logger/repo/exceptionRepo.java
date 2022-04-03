package com.spring.assignmentOne.aspect.logger.repo;

import com.spring.assignmentOne.aspect.logger.domain.exception;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface exceptionRepo extends CrudRepository<exception, Long> {
}
