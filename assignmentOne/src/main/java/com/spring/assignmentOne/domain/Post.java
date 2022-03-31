package com.spring.assignmentOne.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {

    private int id;
    private String title;
    private String content;
    private String author;
}
