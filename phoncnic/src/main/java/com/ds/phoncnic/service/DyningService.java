package com.ds.phoncnic.service;

public interface DyningService {

    // PageResultDTO<DyningDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    // default Map<String, Object> dtoToEntity(DyningDTO dto) {
    //     Map<String, Object> entityMap = new HashMap<>();

    //     Member member = Member.builder().id(dto.getId()).build();

    //     Dyning dyning = Dyning.builder()
    //             .dno(dto.getDno())
    //             .dyningname(dto.getDyningname())
    //             .roofdesign(dto.getRoofdesign())
    //             .location(dto.getLocation())
    //             .foodtype(dto.getFoodtype())
    //             .businesshours(dto.getBusinesshours())
    //             .comment(dto.getComment())
    //             .backgoundimagepath(dto.getBackgoundimagepath())
    //             .menuimagepath(dto.getMenuimagepath())
    //             .hashtag(dto.getHashtag())
    //             .ceoid(member)
    //             .build();
    //     entityMap.put("dyning", dyning);

    //     List<DyningImageDTO> dyningImageDTOList = dto.getDyningImageDTOList();

    //     if (dyningImageDTOList != null && dyningImageDTOList.size() > 0) {
    //         List<DyningImage> dyningImageList = dyningImageDTOList.stream().map(DyningImageDTO -> {
    //             DyningImage dyningImage = DyningImage.builder()
    //                     .menuimagename(DyningImageDTO.getMenuimagename())
    //                     .menuimagepath(DyningImageDTO.getMenuimagepath())
    //                     .backgroundname(DyningImageDTO.getBackgroundname())
    //                     .backgroundpath(DyningImageDTO.getBackgroundpath())
    //                     .dno()
    //                     .build();

    //             return dyningImage;
    //         }).collect(Collectors.toList());

    //         entityMap.put("dyningImageList", dyningImageList);
    //     }
    //     return entityMap;
    // }

    // default Dyning dtoToEntity(DyningDTO dyningDTO) {

    // Member member = Member.builder().id(dyningDTO.getId()).build();

    // Dyning dyning = Dyning.builder()

    // .dno(dyningDTO.getDno())
    // .dino(dyningDTO.getDino())
    // .dyningname(dyningDTO.getDyningname())
    // .roofdesign(dyningDTO.getRoofdesign())
    // .location(dyningDTO.getLocation())
    // .foodtype(dyningDTO.getFoodtype())
    // .businesshours(dyningDTO.getBusinesshours())
    // .comment(dyningDTO.getComment())
    // .backgoundimagepath(dyningDTO.getBackgoundimagepath())
    // .menuimagepath(dyningDTO.getMenuimagepath())
    // .hashtag(dyningDTO.getHashtag())
    // .ceoid(member)
    // .build();

    // return dyning;
    // }

    // default DyningDTO entityToDTO(Dyning dyning, List<DyningImage> dyningImages)
    // {
    // DyningDTO dyningDTO = DyningDTO.builder()
    // .dno(dyning.getDno())
    // .dino(dyning.getDino())
    // .dyningname(dyning.getDyningname())
    // .roofdesign(dyning.getRoofdesign())
    // .location(dyning.getLocation())
    // .foodtype(dyning.getFoodtype())
    // .businesshours(dyning.getBusinesshours())
    // .comment(dyning.getComment())
    // .backgoundimagepath(dyning.getBackgoundimagepath())
    // .menuimagepath(dyning.getMenuimagepath())
    // .hashtag(dyning.getHashtag())
    // .id(dyning.getCeoid().getId())
    // .build();

    // List<DyningImageDTO> dyningImageDTOList =
    // dyningImages.stream().map(dyningImage -> {
    // return DyningImageDTO.builder()
    // // .dno(dyningImage.getDyning())
    // .backgroundname(dyningImage.getBackgroundname())
    // .backgroundpath(dyningImage.getBackgroundpath())
    // .menuimagename(dyningImage.getMenuimagename())
    // .menuimagepath(dyningImage.getMenuimagepath())
    // .build();
    // }).collect(Collectors.toList());

    // dyningDTO.setDyningImageDTOList(dyningImageDTOList);

    // return dyningDTO;
    // }
}
