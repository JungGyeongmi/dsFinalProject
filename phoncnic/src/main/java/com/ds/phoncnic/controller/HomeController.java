package com.ds.phoncnic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class HomeController {
    
    @GetMapping({"","/"})
    public String home(){
        return "index";
    }

    @GetMapping("/crossroad")
    public String crossRoad() {
        return "crossroad";
    }


    /*
        dyning에서 restaurnat 랑 cafe가는 controller 어떻게 했는지 확인하고
        url어떻게 받으면 좋을지 생각해봐야함 
    */
    @GetMapping("/crossroad/{choice}")
    public String crossRoad(@PathVariable("choice") String choice) {
        log.info("get"+choice+".......");
        return "redirect:/"+choice;
    }

}
