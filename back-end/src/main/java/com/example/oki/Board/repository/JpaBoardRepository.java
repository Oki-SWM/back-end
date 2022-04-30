package com.example.oki.Board.repository;

import com.example.oki.Board.domain.Board;
import com.example.oki.Board.domain.Keyword;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaBoardRepository implements BoardRepository{

    private final EntityManager em;

    public JpaBoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Board save(Board board) {
        em.persist(board);
        return board;
    }

    @Override
    public void delete(Long id) {
        em.createQuery("delete from Board b where b.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Board> getBySubject(String keyword) {
        return em.createQuery("select b from Board b where b.subject.keyword = :keyword", Board.class)
                .setParameter("keyword", keyword)
                .getResultList();
    }

    @Override
    public Optional<Board> findById(Long id) {
        Board board = em.find(Board.class, id);
        return Optional.ofNullable(board);
    }
}
