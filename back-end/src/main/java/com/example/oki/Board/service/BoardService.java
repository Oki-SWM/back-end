package com.example.oki.Board.service;

import com.example.oki.Board.domain.Board;
import com.example.oki.Board.domain.Keyword;
import com.example.oki.Board.dto.BoardDto;
import com.example.oki.Board.repository.BoardRepository;
import com.example.oki.Board.repository.KeywordRepository;
import com.example.oki.member.domain.Member;
import com.example.oki.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class BoardService {

    private BoardRepository boardRepository;
    private KeywordRepository keywordRepository;

    @Autowired
    private MemberRepository memberRepository;

    public BoardService(BoardRepository boardRepository, KeywordRepository keywordRepository) {
        this.boardRepository = boardRepository;
        this.keywordRepository = keywordRepository;
    }

    // 게시물 생성
    public Long createBoard(BoardDto boardDto) {

        Member creator = memberRepository.findById(boardDto.getCreatorId()).get();
        Keyword subject = keywordRepository.findByKeyword(boardDto.getKeyword()).get();

        Board board = new Board(creator, subject, boardDto.getCreateTime(), boardDto.getImgPath());
        boardRepository.save(board);

        return board.getId();
    }

    // 게시물 삭제
    public void deleteBoard(Long id) {
        boardRepository.delete(id);
    }

    // 게시물 찾기
    public Optional<Board> findBoard(Long id) {
        return boardRepository.findById(id);
    }

    // 키워드별 게시물 가져오기
    public List<Board> getBoards(String keyword) {

        Keyword subject = keywordRepository.findByKeyword(keyword).get();

        return boardRepository.getBySubject(subject);
    }
}