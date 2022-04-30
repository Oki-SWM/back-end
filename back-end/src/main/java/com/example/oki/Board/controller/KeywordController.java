package com.example.oki.Board.controller;

import com.example.oki.Board.domain.Keyword;
import com.example.oki.Board.dto.LikeDto;
import com.example.oki.Board.service.KeywordService;
import com.example.oki.Board.service.LikeService;
import com.example.oki.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RequestMapping("/keyword")
public class KeywordController {

    private final KeywordService keywordService;

    public KeywordController(KeywordService keywordService) {
        this.keywordService = keywordService;
    }

    // 좋아요 생성
    @GetMapping
    public ResponseEntity<Message> findByDate(@RequestParam(value = "date") String date) {

        Optional<Keyword> keyword = keywordService.getByDate(date);

        if (keyword.isEmpty()) {
            Message message = new Message(HttpStatus.NOT_FOUND, "No Keyword for chosen date", null);
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        else {
            Message message = new Message(HttpStatus.OK, "Success", keyword);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }
}
