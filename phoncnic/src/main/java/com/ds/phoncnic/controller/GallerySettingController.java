package com.ds.phoncnic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/gallery/setting/")
public class GallerySettingController {


    @GetMapping({"/", ""})
    public void galleryRegister(Model model) {

        // model.addAttribute("ImgDTO", arg1)
    }

    @GetMapping("/register")
    public String register() {
        
        return "/gallery/setting/register"; 
    }

    @PostMapping("/register")
    public String register(Model model) { // Ino 넘겨받기
        // Ino 넘겨받아서 repository save
        log.info("register gallery image ...... "); // Ino 추가
        return "redirect:/list";
    }

    @GetMapping("/read")
    public String read() {
        log.info("register read.......");
        
        return "gallery/setting/read";
    }

    @PostMapping("/read/modify")
    public String modify(){
        // save
        log.info("modified......");//수정된 이미지번호
        return "redirect:/gallery/setting/read"; 
    }

    @PostMapping("/read/remove")
    public String remove() {
        // save 
        log.info("removed......");//삭제된 이미지번호
        return "redirect:/gallery/setting/";
    }
}
