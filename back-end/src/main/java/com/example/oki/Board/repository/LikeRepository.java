package com.example.oki.Board.repository;

import com.example.oki.Board.domain.Like;

import java.util.Optional;

public interface LikeRepository {
    // 좋아요 생성
    Like save(Like like);

    // 좋아요 삭제
    void delete(Long boardId, Long memberId);

    // 게시물별 좋아요 수
    Long countByBoard(Long id);

    // 유저별 좋아요 수
    Long countByMember(Long id);

    // 중복 검사
    Optional<Like> validateDuplicate(Like like);
}
