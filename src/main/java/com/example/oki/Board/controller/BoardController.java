package com.example.oki.Board.controller;

import com.example.oki.Board.domain.Board;
import com.example.oki.Board.dto.BoardDto;
import com.example.oki.Board.service.BoardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
    public String list(@RequestParam(value = "subject") String subject, Model model) throws JsonProcessingException {

        List<Board> boards = boardService.getBoards(subject);
        model.addAttribute("boards", mapper.writeValueAsString(boards));

        return "board/list";
    }

    // 게시판 생성 폼
    @GetMapping("/form")
    public String createForm() {
        return "board/form";
    }

    // 게시판 생성
    @PostMapping("/")
    public String create(@RequestBody BoardDto boardDto) {
        boardService.createBoard(boardDto);

        return "redirect:/board";
    }

    // 게시판 삭제
    @DeleteMapping("/")
    public String delete(@RequestParam(value = "id") Long id) {
        boardService.deleteBoard(id);

        return "redirect:/board";
    }

}
