package com.example.oki.Board.repository;

import com.example.oki.Board.domain.Like;
import javax.persistence.EntityManager;

public class JpaLikeRepository implements LikeRepository{

    private final EntityManager em;

    public JpaLikeRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Like save(Like like) {
        em.persist(like);
        return like;
    }

    @Override
    public void delete(Long boardId, Long memberId) {
        em.createQuery("delete from Like l where l.follower.id = :memberId and l.following.id = :boardId")
                .setParameter("boardId", boardId)
                .setParameter("memberId", memberId)
                .executeUpdate();
    }

    @Override
    public Long countByBoard(Long id) {
        return em.createQuery("select count(l) from Like l where l.following.id = :id", Long.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Long countByMember(Long id) {
        return em.createQuery("select count(l) from Like l where l.follower.id = :id", Long.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
