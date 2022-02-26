package com.ds.phoncnic.controller;

import com.ds.phoncnic.dto.MyPageDTO;
import com.ds.phoncnic.service.MyPageService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/main/mypage")
@RequiredArgsConstructor
public class MyPageController {
    private final MyPageService myPageService;

   

        @GetMapping({"/",""})
    //커맨드 객체는 클라이언트로부터 매개변수를 객체 이름으로 받을수 있고,
    //다음 페이지에 커맨드 객체를 넘겨서 사용가능
    //@ModelAttribute 없어도 처리 가능, 명시적으로 처리
    public void getMyPage(String id,Model model){
    MyPageDTO myPageDTO = myPageService.get(id);
   
    model.addAttribute("myPageDTO",myPageDTO);
     
    }
}
