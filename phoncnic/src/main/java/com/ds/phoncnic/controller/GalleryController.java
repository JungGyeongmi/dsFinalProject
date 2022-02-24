package com.ds.phoncnic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/gallery")
@Log4j2
public class GalleryController {
    
    @GetMapping("/list")
    public String galleryRegister(Model model) {

        // model.addAttribute("ImgDTO", arg1)
        return "/register/list";
    }

    @GetMapping("/")
    public String register() {
        
        return "/register/register"; // 문제부분 register폴더의 register 파일
    }

    @PostMapping("/")
    public String register(Model model) { // Ino 넘겨받기
        // Ino 넘겨받아서 repository save
        log.info("register gallery image ...... "); // Ino 추가
        return "redirect:/register/list";
    }

    @GetMapping("/read")
    public String read() {
        log.info("register read.......");
        return "/read";
    }


    @PostMapping("/read/modify")
    public String modify(){
        // save
        log.info("modified......");//수정된 이미지번호
        return "redirect:/register/read"; 
    }

    @PostMapping("/read/remove")
    public String remove() {
        // save 
        log.info("removed......");//삭제된 이미지번호
        return "redirect:/register/list";
    }
}
