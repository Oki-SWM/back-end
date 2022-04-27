package com.example.oki.member.repository;

import com.example.oki.member.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Override
    public void save(Member member) {
        em.persist(member);
    }

    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByMemberId(String memberId) {
        List<Member> result = em.createQuery("select m from Member m where m.memberId = :memberId", Member.class)
                .setParameter("memberId", memberId)
                .getResultList();
        return result.stream().findAny();
    }
}
