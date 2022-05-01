package com.example.oki.Board.repository;

import com.example.oki.Board.domain.Keyword;

import java.time.LocalDate;
import java.util.Optional;

public interface KeywordRepository {
    // keyword id 찾기
    Optional<Keyword> findByKeyword(String keyword);

    Optional<Keyword> findByDate(String date);
}
