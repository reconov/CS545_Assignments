package com.spring.assignmentOne.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic( optional = false)
    @NotNull
    @Column( nullable = false)
    private Long id;
    private String name;

    @ManyToOne()
    @JoinColumn()
    @JsonBackReference()
    private Post post;

}
