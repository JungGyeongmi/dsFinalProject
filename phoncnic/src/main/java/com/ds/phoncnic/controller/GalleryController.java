package com.ds.phoncnic.controller;

import com.ds.phoncnic.dto.PageRequestDTO;
import com.ds.phoncnic.entity.Gallery;
import com.ds.phoncnic.entity.GalleryImage;
import com.ds.phoncnic.repository.GalleryRepository;
import com.ds.phoncnic.repository.MemberRepository;
import com.ds.phoncnic.service.GalleryService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/gallery")
@RequiredArgsConstructor
@Log4j2
public class GalleryController {

    private final MemberRepository memberRepository;
    private final GalleryRepository galleryRepository;
    private final GalleryService galleryService;

    // 선택전 url 에서는 /phoncnic/gallery 로 표기
    @GetMapping({"/", ""})
    public String galleryCrossroad() {
        log.info("GET crossgallery......");
        return "/gallery/crossgallery";
    }

    //사진전 / 그림전 선택페이지
    // @GetMapping("/crossgallery")
    // public String crossgallery(){
    //     return "gallery/crossgallery";
    // }

    // 그림전 및 사진전 선택
    @GetMapping("/crossgallery/{choice}")
    public String crossgalleryPhoto(@PathVariable("choice") String choice){
        log.info("get"+choice+".......");
        return "redirect:/gallery/"+choice;
    }

    /* 
        상세페이지들은 전송해야할 데이터가 다르니까
        합치는거는 고려해봐야할거같슈 아니면 합치고
        삼항연산자 써서 photo일 경우에는 해당 자료값만 넘기는 식으로 해야할거 같슈
        읽고나면 삭제 부탁드려용 ㅇ_<~*
    */
    
    //사진전 상세페이지
    @GetMapping("/photo")
    public String photo(){
        return "gallery/photo";
    }

    //그림전 상세페이지
    @GetMapping("/painting")
    public String painting(){
        return "gallery/painting";
    }
    
    /* 
        테스트용 컨트롤러 
    */

    // 더미 DTO 출력 테스트 
    @GetMapping({"/list"})
    public String list(PageRequestDTO pageRequestDTO, Model model) {

        model.addAttribute("result", galleryService.getList(pageRequestDTO));

        return "/gallery/list";
    }

    // 데이터 수정 테스트
    @PostMapping("/list")
    public String list(String galleryCt){
        log.info("변경할 값"+galleryCt);
        
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
        galleryRepository.save(gallery);
        return "redirect:/gallery/list";
    }
    
}
