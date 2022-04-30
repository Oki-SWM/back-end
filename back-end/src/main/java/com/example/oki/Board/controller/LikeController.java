package com.example.oki.Board.controller;

import com.example.oki.Board.dto.LikeDto;
import com.example.oki.Board.service.LikeService;
import com.example.oki.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    // 좋아요 생성
    @PostMapping
    public ResponseEntity<Message> create(@RequestBody LikeDto likeDto) {

        if (likeService.createLike(likeDto) == null) {
            Message message = new Message(HttpStatus.NOT_FOUND, "Incorrect memberid or boardid", null);
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        else {
            Message message = new Message(HttpStatus.OK, "Success", null);

            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }

    // 좋아요 삭제
    @DeleteMapping
    public ResponseEntity<Message> delete(@RequestParam(value = "memberId") Long memberId, @RequestParam(value = "boardId") Long boardId) {
        likeService.deleteLike(boardId, memberId);

        Message message = new Message(HttpStatus.OK, "Success", null);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // 사용자 좋아요 개수
    @GetMapping("/member")
    public ResponseEntity<Message> getMemberCnt(@RequestParam(value = "id") Long id) {
        Long cnt = likeService.getMemberCnt(id);

        Message message = new Message(HttpStatus.OK, "Success", cnt);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // 게시물 좋아요 개수
    @GetMapping("/board")
    public ResponseEntity<Message> getBoardCnt(@RequestParam(value = "id") Long id) {
        Long cnt = likeService.getBoardCnt(id);

        Message message = new Message(HttpStatus.OK, "Success", cnt);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
