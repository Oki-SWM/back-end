package com.example.oki.Board.service;

import com.example.oki.Board.domain.Board;
import com.example.oki.Board.repository.BoardRepository;

import java.util.List;

public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 게시물 생성
    public Long createBoard(Board board) {
        boardRepository.save(board);
        return board.getId();
    }

    // 게시물 삭제
    public void deleteBoard(Long id) {
        boardRepository.delete(id);
    }

    // 키워드별 게시물 가져오기
    public List<Board> getBoards(String subject) {
        return boardRepository.getBySubject(subject);
    }
}