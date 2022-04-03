package com.spring.assignmentOne.aspect.logger.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Logger {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private String transaction_id;

    private LocalDate date;
    private LocalTime time;
    private String principle;
    private String operation;

}
