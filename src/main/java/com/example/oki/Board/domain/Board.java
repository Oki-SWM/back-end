package com.example.oki.Board.domain;

import com.example.oki.member.domain.Member;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator")
    private Member creator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject")
    private Keyword subject;

    @Column(nullable = false)
    private String createTime;

    @Column(nullable = false)
    private String imgPath;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "following")
    private List<Like> followings = new ArrayList<>();
}
