package com.ds.phoncnic.service;

import com.ds.phoncnic.dto.MyPageDTO;
import com.ds.phoncnic.entity.CharacterLookInfo;
import com.ds.phoncnic.entity.Member;


public interface MyPageService {
    
    MyPageDTO getMyPage(String id);
    // void modify(MemberDTO dto);


    default Member dtoToEntity(MyPageDTO mypageDTO) {
        Member member = Member.builder()
                .id(mypageDTO.getId())
                .nickname(mypageDTO.getNickname())
                .password(mypageDTO.getPassword())
                .build();
        return member;

    }

    //엔티티들을 취합해서 MyPageDTO로 변환
    default MyPageDTO entitiesToMyPageDTO(Member member, CharacterLookInfo characterLookInfo){
        MyPageDTO memberDTO = MyPageDTO.builder()
        .id(member.getId())
        .nickname(member.getNickname())
        .password(member.getPassword())
        .regdate(member.getRegDate())
        .moddate(member.getModDate())
        .hairname(characterLookInfo.getHairname())
        .hairpath(characterLookInfo.getHairpath())
        .clothesname(characterLookInfo.getClothesname())
        .clothespath(characterLookInfo.getClothespath())
        .build();
        return memberDTO;
    }


    
}
        
