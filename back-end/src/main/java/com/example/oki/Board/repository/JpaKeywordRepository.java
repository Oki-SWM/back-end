package com.example.oki.Board.repository;

import com.example.oki.Board.domain.Keyword;

import javax.persistence.EntityManager;
import java.util.Optional;

public class JpaKeywordRepository implements KeywordRepository {

    private final EntityManager em;

    public JpaKeywordRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Keyword> findByKeyword(String keyword) {
        return em.createQuery("select k from Keyword k where k.keyword = :keyword", Keyword.class)
                .setParameter("keyword", keyword)
                .getResultList().stream().findAny();
    }
}
