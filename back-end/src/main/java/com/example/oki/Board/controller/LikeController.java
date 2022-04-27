package com.example.oki.Board.controller;

import com.example.oki.Board.dto.LikeDto;
import com.example.oki.Board.service.LikeService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    // 좋아요 생성
    @PostMapping("/")
    public String create(@RequestBody LikeDto likeDto) {
        likeService.createLike(likeDto);

        return "";
    }

    // 좋아요 삭제
    @DeleteMapping("/")
    public String delete(@RequestBody Long memberId, Long boardId) {
        likeService.deleteLike(boardId, memberId);

        return "";
    }

    // 사용자별 좋아요 가져오기기
    @GetMapping("/member")
    public String getMemberCnt(@RequestBody Long memberId) {
        Long cnt = likeService.getMemberCnt(memberId);
        
        return "";
    }

}
