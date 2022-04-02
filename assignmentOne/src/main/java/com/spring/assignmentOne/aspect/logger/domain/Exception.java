package com.spring.assignmentOne.aspect.logger.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exception {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private String transaction_id;

    private LocalDate date;
    private long timeMs;
    private String principle = "some principle here";
    private String operation;
    private String exceptionTime;



}