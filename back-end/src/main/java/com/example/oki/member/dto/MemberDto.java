package com.example.oki.member.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberDto {

    private String name;

    private String memberId;

    private String password;

    private LocalDateTime loginTime;
}
