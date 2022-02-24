package com.ds.phoncnic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class HomeController {
    
    @GetMapping({"","/"})
    public String home(){
        return "index";
    }

    // 생각해보니까 이게 다 기존 url이랑 달라서 redirect해줘야 할듓..
    // 아닐시 수정하겠슴
    @RequestMapping("/crossroad")
    @GetMapping("/gallery")
    public String toGallery() {
        log.info("gallery.......");
        return "redircet:/gallery/list";
    }

    @RequestMapping("/crossroad")
    @GetMapping("/restaurant")
    public String toRestaurant() {
        log.info("restaurant.......");
        return "redirect:/dyning/restaurant";
    }

    @RequestMapping("/crossroad")
    @GetMapping("/cafe")
    public String toCafe() {
        log.info("cafe.......");
        return "redirect:/dyning/cafe";
    }

    // REGISTER PAGE
    @RequestMapping("/register")
    @GetMapping("/gallery")
    public String toRegisterGallery() {
        log.info("gallery register.......");
        return "redirect:/gallery/register";
    }


}
