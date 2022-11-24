package com.example.springjpamapping.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@NoArgsConstructor
@Getter
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

    @Builder
    public Comment(String title, String content, String user, Hospital hospital) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.hospital = hospital;
    }
}
