package com.example.oki.Board.repository;

import com.example.oki.Board.domain.Board;
import com.example.oki.Board.domain.Keyword;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    // 게시물 생성
    Board save(Board board);

    // 게시물 삭제
    void delete(Long id);

    // 키워드별로 가져오기
    List<Board> getBySubject(Keyword subject);

    // id로 찾기
    Optional<Board> findById(Long id);
}
