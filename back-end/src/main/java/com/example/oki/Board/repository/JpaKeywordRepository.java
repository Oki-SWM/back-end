package com.example.oki.Board.repository;

import com.example.oki.Board.domain.Keyword;

import javax.persistence.EntityManager;
import java.time.LocalDate;
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

    @Override
    public Optional<Keyword> findByDate(String date) {
        return em.createQuery("select k from Keyword k where k.date = :date", Keyword.class)
                .setParameter("date", date)
                .getResultList().stream().findAny();
    }
}
