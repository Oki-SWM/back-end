package com.example.oki.Board.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "keyword_id")
    private Keyword keyword;

    @Column(nullable = false)
    private String createTime;

    @Column(nullable = false)
    private String imgPath;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "board")
    private List<Like> likes = new ArrayList<Like>();
}
