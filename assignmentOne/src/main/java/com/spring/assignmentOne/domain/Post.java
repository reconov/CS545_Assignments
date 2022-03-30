package com.spring.assignmentOne.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {

    int id;
    String title;
    String content;
    String author;
}
