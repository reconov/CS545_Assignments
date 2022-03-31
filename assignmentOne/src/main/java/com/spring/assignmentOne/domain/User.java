package com.spring.assignmentOne.domain;

import lombok.Data;

import java.util.List;

@Data
public class User {

    long id;
    String name;
    List<Post> posts;
}
