package com.ds.phoncnic.controller.dyningController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/dyning")
public class DyningController {

    // private final DyningService dyningService;

    // 음식점 거리 페이지
    // @GetMapping("/restaurant/list")
    // public String restaurantList(Model model) {
    //     log.info("restaurant list...........");
    //     // model.addAttribute("result", dyningService.getList(pageRequestDTO));

    //     return "restaurant/list";
    // }

    // 카페 거리 페이지
    // @GetMapping("/cafe/list")
    // public String cafeList(Model model) {
    //     log.info("cafe list.................");
    //     // model.addAttribute("result", dyningService.getList(pageRequestDTO));

    //     return "cafe/list";
    // }

    

    @GetMapping({"/{choice}", "/{choice}/list/","/{choice}/list"})
    public String getList(@PathVariable("choice") String choice, Model model) {
        log.info(choice+"list.................");
        // model.addAttribute("result", dyningService.getList(pageRequestDTO));

        return "dyning/"+choice+"/list";
    }


}
