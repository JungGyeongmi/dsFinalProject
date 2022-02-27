package com.ds.phoncnic.controller;

import com.ds.phoncnic.dto.MemberDTO;
import com.ds.phoncnic.service.MemberService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MyPageController {
    private final MemberService memberService;

    // @GetMapping("/main/mypage")
    // public String mypage() {
    //     return "/main/mypage";
    // }
    @GetMapping("/main/mypage")
    public void mypage(String id,Model model){
        log.info("id:"+id);
        MemberDTO memberDTO = memberService.getMyPage(id);
        model.addAttribute("memberDTO", memberDTO);
    }
   
    
}
