package com.ds.phoncnic.service;

import com.ds.phoncnic.dto.MyPageDTO;
import com.ds.phoncnic.entity.CharacterLook;

public interface CharacterLookService {

    
 
    default CharacterLook dtoToEntity(MyPageDTO mypageDTO) {

        CharacterLook characterLook = CharacterLook.builder()
        .hairname(mypageDTO.getHairname())
        .clothesname(mypageDTO.getClothesname())
        .build();

        return characterLook;

    }
}
