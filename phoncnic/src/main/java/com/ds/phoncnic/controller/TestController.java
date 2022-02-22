package com.ds.phoncnic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;


@Log4j2
@Controller
public class TestController {
    
    // private final MemberRepository memberRepository;

    @GetMapping
    public String testMember(Model model) {

        // memberDTO member = memberRepository.

        // model.addAttribute("memberList", member);
        return "/test/member";
    }
}
