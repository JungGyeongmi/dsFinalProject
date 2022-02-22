package com.ds.phoncnic.controller;

import com.ds.phoncnic.dto.PageRequestDTO;
import com.ds.phoncnic.service.MemberService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class TestController {

    private final MemberService memberService;

    @GetMapping("/list")
    public String testMember(Model model, PageRequestDTO pageRequestDTO) {
        
        log.info("list.............");
        model.addAttribute("result", memberService.getList(pageRequestDTO));

        return "/member/listTest";
    }
}
