package com.ds.phoncnic.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ds.phoncnic.dto.DyningDTO;
import com.ds.phoncnic.dto.DyningImageDTO;
import com.ds.phoncnic.dto.PageRequestDTO;
import com.ds.phoncnic.dto.PageResultDTO;
import com.ds.phoncnic.entity.Dyning;
import com.ds.phoncnic.entity.DyningImage;
import com.ds.phoncnic.entity.Member;

public interface DyningService {

    Long register(DyningDTO dyningDTO);

    PageResultDTO<DyningDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    default Map<String, Object> dtoToEntity(DyningDTO dto) {
        Map<String, Object> entityMap = new HashMap<>();

        Member member = Member.builder().id(dto.getId()).build();

        Dyning dyning = Dyning.builder()
                .dno(dto.getDno())
                .dyningname(dto.getDyningname())
                .roofdesign(dto.getRoofdesign())
                .location(dto.getLocation())
                .foodtype(dto.getFoodtype())
                .businesshours(dto.getBusinesshours())
                .comment(dto.getComment())
                .hashtag(dto.getHashtag())
                .ceoid(member)
                .build();
        entityMap.put("dyning", dyning);

        List<DyningImageDTO> dyningImageDTOList = dto.getDyningImageDTOList();

        if (dyningImageDTOList != null && dyningImageDTOList.size() > 0) {
            List<DyningImage> dyningImageList = dyningImageDTOList.stream().map(DyningImageDTO -> {
                DyningImage dyningImage = DyningImage.builder()
                        .menuimagename(DyningImageDTO.getMenuimagename())
                        .menuimagepath(DyningImageDTO.getMenuimagepath())
                        .backgroundname(DyningImageDTO.getBackgroundname())
                        .backgroundpath(DyningImageDTO.getBackgroundpath())
                        .dyning(dyning)
                        .build();

                return dyningImage;
            }).collect(Collectors.toList());

            entityMap.put("dyningImageList", dyningImageList);
        }
        return entityMap;
    }

    default DyningDTO entityToDTO(Dyning dyning, List<DyningImage> dyningImages) {
        DyningDTO dyningDTO = DyningDTO.builder()
                .dno(dyning.getDno())
                .dyningname(dyning.getDyningname())
                .roofdesign(dyning.getRoofdesign())
                .location(dyning.getLocation())
                .foodtype(dyning.getFoodtype())
                .businesshours(dyning.getBusinesshours())
                .comment(dyning.getComment())
                .hashtag(dyning.getHashtag())
                .id(dyning.getCeoid().getId())
                .regdate(dyning.getRegDate())
                .moddate(dyning.getModDate())
                .build();

        List<DyningImageDTO> dyningImageDTOList = dyningImages.stream().map(dyningImage -> {
            return DyningImageDTO.builder()
                    .backgroundname(dyningImage.getBackgroundname())
                    .backgroundpath(dyningImage.getBackgroundpath())
                    .menuimagename(dyningImage.getMenuimagename())
                    .menuimagepath(dyningImage.getMenuimagepath())
                    .build();
        }).collect(Collectors.toList());

        dyningDTO.setDyningImageDTOList(dyningImageDTOList);

        return dyningDTO;
    }

}
