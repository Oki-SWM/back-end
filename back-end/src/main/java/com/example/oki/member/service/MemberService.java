package com.example.oki.member.service;

import com.example.oki.Board.domain.Board;
import com.example.oki.member.domain.Member;
import com.example.oki.member.dto.MemberDto;
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

    public boolean signUpMember(MemberDto memberDto) {
        if (memberRepository.findByMemberId(memberDto.getMemberId()).isPresent())
            return false;
        Member member = new Member(memberDto.getName(), memberDto.getMemberId(), memberDto.getPassword(), LocalDateTime.now());
        memberRepository.save(member);
        return true;
    }

    public Member signInMember(MemberDto memberDto) {
        Optional<Member> loginMember = memberRepository.findByMemberId(memberDto.getMemberId()).
                filter(m -> m.getPassword().equals(memberDto.getPassword()));
        if (loginMember.isEmpty()) {
            return null;
        }
        LocalDateTime date = LocalDateTime.now();
        loginMember.get().setLoginTime(date);
        return loginMember.get();
    }
}
