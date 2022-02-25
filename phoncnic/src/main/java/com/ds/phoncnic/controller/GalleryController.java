package com.ds.phoncnic.controller;


@Controller
@RequestMapping("/gallery")
@RequiredArgsConstructor
@Log4j2
public class GalleryController {

    private final MemberRepository memberRepository;
    private final GalleryRepository galleryRepository;
    private final GalleryService galleryService;

    //사진전 / 그림전 선택페이지
    @GetMapping("/crossgallery")
    public String crossgallery(){
        return "gallery/crossgallery";
    }

    //사진전 선택시
    @GetMapping("/crossgallery/photo")
    public String crossgalleryPhoto(){
        return "redirect:/gallery/photo";
    }

    //그림전 선택시
    @GetMapping("/crossgallery/painting")
    public String crossgalleryPainting(){
        return "redirect:/gallery/painting";

    }
    
    //전시회 관람 페이지
    @GetMapping("/")
    public String gallerySetting(Model model) {

        // model.addAttribute("ImgDTO", arg1)
        return "/setting/";
    }

    @GetMapping("/setting/register")
    public String register() {
        
        return "/setting/register"; 
    }

    @PostMapping("/setting/register")
    public String register(Model model) { // Ino 넘겨받기
        // Ino 넘겨받아서 repository save
        log.info("register gallery image ...... "); // Ino 추가
        return "redirect:/setting";
    }

    @GetMapping("/setting/read")
    public String read() {
        log.info("register read.......");
        return "/read";
    }

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
    
    @GetMapping("/list")
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

    @PostMapping("/read/remove")
    public String remove() {
        // save 
        log.info("removed......");//삭제된 이미지번호
        return "redirect:/register/list";
    }
    
}
