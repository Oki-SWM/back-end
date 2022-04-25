package com.example.oki.member.service;

import com.example.oki.member.domain.Member;
import com.example.oki.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public void signUpMember(Member m){
        memberRepository.save(m);
    }
}
