package com.example.oki.member.repository;

import com.example.oki.member.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(String memberId);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
