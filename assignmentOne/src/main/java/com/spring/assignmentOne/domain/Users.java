package com.spring.assignmentOne.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;

//    @OneToMany( cascade = CascadeType.ALL)
//    @JoinColumn( name = "user_id", referencedColumnName = "id")
    @OneToMany( mappedBy = "user")
    @JsonManagedReference
    private List<Post> posts;

}
