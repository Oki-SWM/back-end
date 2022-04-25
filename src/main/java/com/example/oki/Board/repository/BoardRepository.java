package com.example.oki.Board.repository;

import com.example.oki.Board.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    // 게시물 생성
    Board createBoard(Board board);

    // 게시물 삭제
    void deleteBoard(Long id);

    // 키워드별로 가져오기
    List<Board> getBySubject(String subject);

    // id로 찾기
    Optional<Board> findById(Long id);

}
