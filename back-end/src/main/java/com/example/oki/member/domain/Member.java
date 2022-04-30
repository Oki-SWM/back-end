package com.example.oki.member.domain;

import com.example.oki.Board.domain.Board;
import com.example.oki.Board.domain.Like;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String memberId;

    @Column(nullable = false)
    private String password;

    @Column
    private LocalDateTime loginTime;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "creator")
    private List<Board> creators = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "follower")
    private List<Like> followers = new ArrayList<>();

    @Builder
    public Member(String name, String memberId, String password, LocalDateTime loginTime) {
        this.name = name;
        this.memberId = memberId;
        this.password = password;
        this.loginTime = loginTime;
    }
}
