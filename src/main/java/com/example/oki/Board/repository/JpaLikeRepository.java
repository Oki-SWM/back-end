package com.example.oki.Board.repository;

import com.example.oki.Board.domain.Like;

import javax.persistence.EntityManager;

public class JpaLikeRepository implements LikeRepository{

    private final EntityManager em;

    public JpaLikeRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Like createLike(Like like) {
        em.persist(like);
        return like;
    }

    @Override
    public void deleteLike(Long boardId, Long memberId) {

    }

    @Override
    public int countByBoard(Long id) {
        return 0;
    }

    @Override
    public int countByMember(Long id) {
        return 0;
    }
}
