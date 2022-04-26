package com.example.oki.member.repository;

import com.example.oki.member.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository {

    void save(Member member);

    Optional<Member> findByMemberId(String memberId);
}