package com.example.oki.Board.controller;

import com.example.oki.Board.domain.Board;
import com.example.oki.Board.dto.BoardDto;
import com.example.oki.Board.service.BoardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/board")
public class BoardController {

    @Autowired
    private ObjectMapper mapper;

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 게시판 목록
    @GetMapping("/")
    @ResponseBody
    public String list(@RequestParam(value = "subject") String subject) throws JsonProcessingException {

        List<Board> boards = boardService.getBoards(subject);

        return mapper.writeValueAsString(boards);
    }

    // 게시판 생성
    @PostMapping("/")
    @ResponseBody
    public String create(@RequestBody BoardDto boardDto) {
        boardService.createBoard(boardDto);

        return "redirect:/board/"+boardDto.getKeyword();
    }

    // 게시판 삭제
    @DeleteMapping("/")
    public String delete(@RequestParam(value = "id") Long id) {
        Board board = boardService.findBoard(id).get();

        String subject = board.getSubject().getKeyword();

        boardService.deleteBoard(id);

        return "redirect:/board"+subject;
    }
}
