package com.example.oki.Board.domain;

import com.example.oki.member.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Builder
    public Board(Member creator, Keyword subject, String createTime, String imgPath) {
        this.creator = creator;
        this.subject = subject;
        this.createTime = createTime;
        this.imgPath = imgPath;
    }
}