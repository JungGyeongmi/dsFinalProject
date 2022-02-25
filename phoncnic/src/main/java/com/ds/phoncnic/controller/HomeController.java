package com.ds.phoncnic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class HomeController {
    
    @GetMapping({"","/"})
    public String home(){
        return "index";
    }

    @GetMapping("/crossroad")
    public String crossroad(){
        return "crossroad";
    }

    @GetMapping("/crossroad/gallery")
    public String toGalleryCrossroad() {

        return "redirect:/gallery/crossroad";
    }
    
    @GetMapping("/crossroad/restaurant")
    public String toRestaurantCrossroad() {

        return "redirect:/dyning/restaurant";
    }

    @GetMapping("/crossroad/cafe")
    public String toCafeCrossroad() {

        return "redirect:/dyning/cafe";
    }

    @GetMapping("/setting")
    public String setting(){
        return "setting";
    }

    @GetMapping("/gallery/setting")
    public String toGallerySetting() {

        return "redirect:/gallery/setting";
    }

    @GetMapping("/dyning/setting")
    public String toDyningSetting() {

        return "redirect:/dyning/setting";
    }
}
