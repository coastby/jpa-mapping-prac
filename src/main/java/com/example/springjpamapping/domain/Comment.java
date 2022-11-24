package com.example.springjpamapping.domain;


import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String user;
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
