package com.ds.phoncnic.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
public class HomeController {
    
    @GetMapping({"","/"})
    public String home(){
        return "index";
    }

    @GetMapping("/main/companyinfo")
    public String companyinfo() {
        return "/main/companyinfo";
    }

    @GetMapping("/main/help")
    public String help() {
        return "/main/help";
    }

     @GetMapping("/main/mypage")
    public String mypage() {
        return "/main/mypage";
    }
    
   


}
