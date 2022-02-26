package com.ds.phoncnic.service;

import com.ds.phoncnic.dto.MyPageDTO;
import com.ds.phoncnic.entity.CharacterLook;
import com.ds.phoncnic.entity.Member;

public interface MyPageService {
    MyPageDTO get(String id);


    //Entity에서 DTO로 변환할 때
    default MyPageDTO entityToDTO(Member member,Member member2, CharacterLook characterLook,CharacterLook characterLook2){
        MyPageDTO myPageDTO = MyPageDTO.builder()
        .id(member.getId())
        .nickname(member2.getNickname())
        .hair(characterLook.getHair())
        .clothes(characterLook2.getClothes())
        .build();
        return myPageDTO;
    }

    // default MyPageDTO entityToMyPageDTO(Member member,CharacterLook characterLook,CharacterLook characterLook2){
    //     MyPageDTO myPageDTO = MyPageDTO.builder()
    //         .id(member.getId())
    //         .hair(characterLook.getHair())
    //         .clothes(characterLook2.getClothes())
    //         .build();
    //         return myPageDTO;
    //     }
}
