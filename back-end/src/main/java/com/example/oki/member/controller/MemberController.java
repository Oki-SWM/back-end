package com.example.oki.member.controller;

import com.example.oki.member.dto.MemberDto;
import com.example.oki.message.Message;
import com.example.oki.member.domain.Member;
import com.example.oki.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MemberController {

    private final MemberService memberService;

    MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("signup")
    public ResponseEntity<Message> signUp(@RequestBody MemberDto memberDto) {
        if (!memberService.signUpMember(memberDto)) {
            Message message = new Message(HttpStatus.CONFLICT, "Duplicate id", null);
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
        Message message = new Message(HttpStatus.OK, "Success", null);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("signin")
    public ResponseEntity<Message> signIn(@RequestBody MemberDto memberDto) {
        Member loginMember = memberService.signInMember(memberDto);

        if (loginMember == null) {
            Message message = new Message(HttpStatus.NOT_FOUND, "Incorrect Id or Password", null);
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        Message message = new Message(HttpStatus.OK, "Success", loginMember);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
