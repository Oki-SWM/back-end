package com.example.oki.Board.service;

import com.example.oki.Board.domain.Like;
import com.example.oki.Board.repository.LikeRepository;

public class LikeService {

    private LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    // 좋아요 생성
    public Long createLike(Like like) {
        likeRepository.save(like);
        return like.getId();
    }

    // 좋아요 삭제
    public void deleteLike(Long boardId, Long memberId) {
        likeRepository.delete(boardId, memberId);
    }
    
    // 게시물 좋아요 개수
    public Long getBoardCnt(Long id) {
        return likeRepository.countByBoard(id);
    }

    // 유저 게시물의 누적 좋아요 개수
    public Long getMemberCnt(Long id) {
        return likeRepository.countByMember(id);
    }
}
