package com.example.oki.member.repository;

import com.example.oki.member.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    void save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByMemberId(String memberId);
}