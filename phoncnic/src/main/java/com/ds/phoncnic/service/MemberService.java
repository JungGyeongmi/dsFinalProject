package com.ds.phoncnic.service;

import com.ds.phoncnic.dto.MemberDTO;
import com.ds.phoncnic.dto.MyPageDTO;
import com.ds.phoncnic.dto.PageRequestDTO;
import com.ds.phoncnic.dto.PageResultDTO;
import com.ds.phoncnic.entity.CharacterLook;
import com.ds.phoncnic.entity.Member;

import org.springframework.stereotype.Component;

@Component 
public interface MemberService {
    
    PageResultDTO<MemberDTO, Member> getList(PageRequestDTO PageRequestDTO);

    default Member dtoToEntity(MemberDTO memberDTO) {

        Member member = Member.builder()
        .id(memberDTO.getId())
        .nickname(memberDTO.getNickname())
        .password(memberDTO.getPassword())
        .build();

        return member;
    }

    default MemberDTO entityToDTO(Member member) {
        
        MemberDTO memberDTO = MemberDTO.builder()
            .id(member.getId())
            .nickname(member.getNickname())
            .password(member.getPassword())
            .moddate(member.getModDate())
            .regdate(member.getRegDate())
            .build();

            return memberDTO;
        }


    // MyPageDTO get(String id);

    // default MyPageDTO entityToMyPageDTO(Member member,Member member2,CharacterLook characterLook,CharacterLook characterLook2){
    //     MyPageDTO myPageDTO = MyPageDTO.builder()
    //         .id(member.getId())
    //         .nickname(member2.getNickname())
    //         .hair(characterLook.getHair())
    //         .clothes(characterLook2.getClothes())
    //         .build();
    //         return myPageDTO;
    //     }
}
        
