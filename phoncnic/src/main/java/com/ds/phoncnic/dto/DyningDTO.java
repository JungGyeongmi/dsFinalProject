package com.ds.phoncnic.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DyningDTO {
    
    private long dno;

    private long dino;
    private String dyningname;
    private long roofdesign;
    private String location;
    private long foodtype;
    private String businesshours;
    private String comment;
    private String backgoundimagepath;
    private String menuimagepath;
    private String hashtag;

    private LocalDateTime regdate, moddate;

    private String id;

    @Builder.Default 
    private List<DyningImageDTO> dyningImageDTOList = new ArrayList<>();
}
