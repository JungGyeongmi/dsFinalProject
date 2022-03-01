package com.ds.phoncnic.controller;

import com.ds.phoncnic.dto.MyPageDTO;
import com.ds.phoncnic.service.MyPageService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MyPageController {
    private final MyPageService  myPageService;

    // @GetMapping("/main/mypage")
    // public String mypage() {
    //     return "/main/mypage";
    // }
    @GetMapping("/main/mypage")
    public void mypage(String id, Model model){
        log.info("id:"+id);
        MyPageDTO mypageDTO = myPageService.getMyPage(id);
        model.addAttribute("mypageDTO", mypageDTO);
    }

    // @PostMapping("/main/mypage/modify")
    // public String modify(MemberDTO memberDTO, RedirectAttributes ra) {
    //   log.info("modify post.........memberDTO:"+memberDTO.getId());
    //   log.info("dto:"+ memberDTO);
  
    //   memberService.modify(memberDTO);
    //   ra.addAttribute("nickname", memberDTO.getNickname());
  
    //   return "redirect:/main/mypage";
    // }
    
   
    
}
