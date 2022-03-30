package com.spring.assignmentOne.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostV2 {

    int id;
    String title;
    String content;
    String author;
}
