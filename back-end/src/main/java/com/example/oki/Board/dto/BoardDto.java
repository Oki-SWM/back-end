package com.example.oki.Board.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardDto {

    private Long creatorId;

    private String keyword;

    private String comment;
}
