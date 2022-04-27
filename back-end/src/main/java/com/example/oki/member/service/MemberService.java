package com.example.oki.member.service;

import com.example.oki.member.domain.Member;
import com.example.oki.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean signUpMember(Member m) {
        if (memberRepository.findByMemberId(m.getMemberId()).isPresent())
            return false;
        memberRepository.save(m);
        return true;
    }

    public Member signInMember(String memberId, String password) {
        Optional<Member> loginMember = memberRepository.findByMemberId(memberId).
                filter(m -> m.getPassword().equals(password));
        if (loginMember.isEmpty()) {
            return null;
        }
        LocalDateTime date = LocalDateTime.now();
        loginMember.get().setLoginTime(date);
        return loginMember.get();
    }
}
