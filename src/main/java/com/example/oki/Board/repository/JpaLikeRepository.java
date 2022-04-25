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
        Like like = em.createQuery("select l from Like l where l.follower = :memberId and l.following = :boardId", Like.class)
                .setParameter("boardId", boardId)
                .setParameter("memberId", memberId)
                .getSingleResult();
        em.detach(like);
    }

    @Override
    public Long countByBoard(Long id) {
        return em.createQuery("select count(l) from Like l where l.following = :id", Long.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Long countByMember(Long id) {
        return em.createQuery("select count(l) from Like l where l.follower = :id", Long.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
