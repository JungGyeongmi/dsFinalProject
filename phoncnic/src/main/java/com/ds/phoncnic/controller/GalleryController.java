package com.ds.phoncnic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/gallery")
public class GalleryController {
    
    //전시회 관람 페이지
    @GetMapping("/list")
    public String list(Model model){
        log.info("galley list..........................");
        return "gallery/list";
    }
}
