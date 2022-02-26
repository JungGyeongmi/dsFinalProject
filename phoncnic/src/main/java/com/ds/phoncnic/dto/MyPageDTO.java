package com.ds.phoncnic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyPageDTO {
    private String id;
    private String nickname;
    private String hair;
    private String clothes;
}
