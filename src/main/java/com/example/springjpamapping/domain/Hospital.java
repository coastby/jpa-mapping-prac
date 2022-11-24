package com.example.springjpamapping.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hospitalName;
    private String roadNameAddress;
    @OneToMany(mappedBy="hospital", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Comment> commentList = new ArrayList<>();

}
