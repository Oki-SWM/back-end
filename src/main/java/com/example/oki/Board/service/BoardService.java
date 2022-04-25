package com.example.oki.Board.service;

import com.example.oki.Board.domain.Board;
import com.example.oki.Board.domain.Keyword;
import com.example.oki.Board.dto.BoardDto;
import com.example.oki.Board.repository.BoardRepository;
import com.example.oki.Board.repository.KeywordRepository;
import com.example.oki.member.domain.Member;
import com.example.oki.member.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final KeywordRepository keywordRepository;

    public BoardService(BoardRepository boardRepository, MemberRepository memberRepository, KeywordRepository keywordRepository) {
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
        this.keywordRepository = keywordRepository;
    }

    // 게시물 생성
    public Long createBoard(BoardDto boardDto) {

        Member creator = memberRepository.findById(boardDto.getMemberId()).get();
        Keyword subject = keywordRepository.findByKeyword(boardDto.getKeyword()).get();

        Board board = new Board(creator, subject, boardDto.getCreateTime(), boardDto.getImgPath());
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