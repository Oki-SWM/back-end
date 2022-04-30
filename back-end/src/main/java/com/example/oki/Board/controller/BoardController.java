package com.example.oki.Board.controller;

import com.example.oki.Board.domain.Board;
import com.example.oki.Board.dto.BoardDto;
import com.example.oki.Board.service.BoardService;
import com.example.oki.message.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/board")
public class BoardController {

    @Autowired
    private ObjectMapper mapper;

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 게시판 목록
    @GetMapping
    @ResponseBody
    public ResponseEntity<Message> list(@RequestParam(value = "keyword") String keyword) {

        List<Board> boards = boardService.getBoards(keyword);

        if (boards == null) {
            Message message = new Message(HttpStatus.NOT_FOUND, "Incorrect keyword",  null);
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

        Message message = new Message(HttpStatus.OK, "Success", boards);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // 게시판 생성
    @PostMapping
    @ResponseBody
    public ResponseEntity<Message> create(@RequestBody BoardDto boardDto) {
        Long boardId = boardService.createBoard(boardDto);

        if (boardId == null) {
            Message message = new Message(HttpStatus.NOT_FOUND, "Incorrect user or keyword", null);
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        Message message = new Message(HttpStatus.OK, "Success", null);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // 게시판 삭제
    @DeleteMapping
    public ResponseEntity<Message> delete(@RequestParam(value = "id") Long id) {
        Optional<Board> board = boardService.findBoard(id);

        if (board.isEmpty()) {
            Message message = new Message(HttpStatus.NOT_FOUND, "Incorrect board", null);
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

        String subject = board.get().getSubject().getKeyword();

        boardService.deleteBoard(id);

        Message message = new Message(HttpStatus.OK, "Success", null);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
