package com.example.oki.Board.domain;

import com.example.oki.member.domain.Member;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator")
    private Member creator;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject")
    private Keyword subject;

    @Column(nullable = false)
    private LocalDateTime createTime;

    @Column(nullable = false)
    private String comment;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "following")
    private List<Like> followings = new ArrayList<>();

    @Builder
    public Board(Member creator, Keyword subject, LocalDateTime createTime, String comment) {
        this.creator = creator;
        this.subject = subject;
        this.createTime = createTime;
        this.comment = comment;
    }
}
