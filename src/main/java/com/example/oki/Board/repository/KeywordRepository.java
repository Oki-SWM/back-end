package com.example.oki.Board.repository;

import com.example.oki.Board.domain.Keyword;

import java.util.Optional;

public interface KeywordRepository {
    // keyword id 찾기
    Optional<Keyword> findByKeyword(String keyword);
}
