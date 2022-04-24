package com.example.oki.Board.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String keyword;

    @Column(unique = true)
    private String date;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "keyword")
    private List<Board> boards = new ArrayList<Board>();
}
