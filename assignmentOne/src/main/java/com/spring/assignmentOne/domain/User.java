package com.spring.assignmentOne.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class User {

//    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY )
//    @Column( nullable = false)
    private Long id;
    private String name;

//    @OneToMany
//    @JoinColumn( name = "post_user")
//    private List<Post> posts;

}
