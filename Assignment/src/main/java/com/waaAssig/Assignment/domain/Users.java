package com.waaAssig.Assignment.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean enabled;
    

    @OneToMany( mappedBy = "user", cascade = CascadeType.ALL )
    @JsonManagedReference
    private List<Post> posts;

    @ManyToMany
    @JoinTable
    private List<Role> roles;

}
