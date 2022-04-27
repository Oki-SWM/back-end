package com.example.oki.member.service;

import com.example.oki.member.domain.Member;
import com.example.oki.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public boolean signUpMember(Member m) {
        if (memberRepository.findByMemberId(m.getMemberId()).isPresent())
            return false;
        memberRepository.save(m);
        return true;
    }

    public Member signInMember(String memberId, String password) {
        return memberRepository.findByMemberId(memberId).
                filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
