package com.ds.phoncnic.controller;

import com.ds.phoncnic.dto.GalleryDTO;
import com.ds.phoncnic.dto.PageRequestDTO;
import com.ds.phoncnic.entity.Gallery;
import com.ds.phoncnic.entity.GalleryImage;
import com.ds.phoncnic.repository.GalleryImageRepository;
import com.ds.phoncnic.repository.GalleryRepository;
import com.ds.phoncnic.repository.MemberRepository;
import com.ds.phoncnic.service.GalleryImageService;
import com.ds.phoncnic.service.GalleryService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/gallery")
@RequiredArgsConstructor
@Log4j2
public class GalleryController {

    private final GalleryService galleryService;
    private final MemberRepository memberRepository;
    private final GalleryRepository galleryRepository;
    private final GalleryImageRepository galleryImageRepository;

    //전시회 관람 페이지
    @GetMapping("/list")
    public String list(Model model, PageRequestDTO pageRequestDTO){
        log.info("gallery list........................");

        model.addAttribute("result", galleryService.getList(pageRequestDTO));
        return "gallery/list";
    }

    @PostMapping("/list")
    public String list(RedirectAttributes rd, String galleryCt, PageRequestDTO pageRequestDTO){
        log.info("변경할 값"+galleryCt);
        // log.info("modify list....."+GDTO);

        // Gallery gallery = Gallery.builder()
        //     .gno(10L)
        // .build();
        // gallery.setTitle(galleryCt);

        
        GalleryImage galleryImage = GalleryImage.builder()
            .gno(8L)
            .artistid("user10@icloud.com")
            .imagename("나룽나룽")
            .imagepath("나룽.png")
            .build();

        Gallery gallery = Gallery.builder()
        .gno(8L)
        // .image(galleryImage)
        .content(galleryCt)
        .imagepath("나룽.png")
        .title("나룽전")
        .artistid(memberRepository.findById("user10@icloud.com").get())
        .build();
        gallery.setImage(galleryImage);
        // gallery.setContent(galleryCt);

        // galleryImageRepository.save(galleryImage);
        galleryRepository.save(gallery);


        // rd.addAttribute("keyword", pageRequestDTO.getKeyword());



        return "redirect:/gallery/list";
    }
    
}
