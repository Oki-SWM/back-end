package com.example.oki.Board.repository;

import com.example.oki.Board.domain.Like;

public interface LikeRepository {
    // 좋아요 생성
    Like createLike(Like like);

    // 좋아요 삭제
    void deleteLike(Long boardId, Long memberId);

    // 좋아요 찾기

    // 게시물별 좋아요 수
    int countByBoard(Long id);

    // 유저별 좋아요 수
    int countByMember(Long id);
}
