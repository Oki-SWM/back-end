package com.example.oki.member.controller;

import com.example.oki.member.domain.Member;
import com.example.oki.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUp(Member m) {
        memberService.signUpMember(m);

        return "redirect:/board";
    }
}
