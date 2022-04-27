package com.example.oki.member.controller;

import com.example.oki.message.Message;
import com.example.oki.member.domain.Member;
import com.example.oki.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MemberController {

    private final MemberService memberService;

    MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<Message> signUp(@RequestBody Member m) {
        if (memberService.signUpMember(m)) {
            Message message = new Message(HttpStatus.OK, "Success", null);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        Message message = new Message(HttpStatus.CONFLICT, "Duplicate id", null);
        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<Message> signIn(@RequestBody Member m) {
        Member loginMember = memberService.signInMember(m.getMemberId(), m.getPassword());

        if (loginMember == null) {
            Message message = new Message(HttpStatus.NOT_FOUND, "Incorrect Id or Password", null);
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        Message message = new Message(HttpStatus.OK, "Success", loginMember);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
