package com.example.oki.Board.repository;

import com.example.oki.Board.domain.Board;

public interface BoardRepository {
    // 게시물 생성
    Board createBoard(Board board);

    void deleteBoard();
}
