package com.example.oki.Board.repository;

import com.example.oki.Board.domain.Like;

public interface LikeRepository {
    // 좋아요 생성
    Like createLike(Like like);

    // 좋아요 삭제
    void deleteLike();
}
