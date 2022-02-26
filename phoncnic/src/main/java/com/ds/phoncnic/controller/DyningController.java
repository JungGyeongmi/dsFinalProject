package com.ds.phoncnic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/dyning")
public class DyningController {

    // private final DyningService dyningService;

    // 음식점 거리 페이지
    @GetMapping("/restaurant/list")
    public String restaurantList(Model model) {
        log.info("restaurant list...........");
        // model.addAttribute("result", dyningService.getList(pageRequestDTO));

        return "restaurant/list";
    }

    // 카페 거리 페이지
    @GetMapping("/cafe/list")
    public String cafeList(Model model) {
        log.info("cafe list.................");
        // model.addAttribute("result", dyningService.getList(pageRequestDTO));

        return "cafe/list";
    }


}
