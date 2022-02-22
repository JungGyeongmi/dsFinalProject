package com.ds.phoncnic.repository;

import java.util.stream.IntStream;

import com.ds.phoncnic.dto.MemberDTO;
import com.ds.phoncnic.dto.PageRequestDTO;
import com.ds.phoncnic.dto.PageResultDTO;
import com.ds.phoncnic.entity.Member;
import com.ds.phoncnic.service.MemberService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    MemberRepository repository;

    @Autowired
    MemberService memberService;

    @Test
    public void insertDummies() {

        IntStream.rangeClosed(1, 10).forEach(
            i-> {
                Member member = Member.builder()
                .id("user"+i+"@icloud.com")
                .nickname("user"+i)
                .password("1234")
                .build();

                repository.save(member);
            }  

        );

    }
    /* 페이징테스트 */
    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResultDTO<MemberDTO, Member> resultDTO = memberService.getList(pageRequestDTO);
        
        System.out.println("PREV : "+resultDTO.isPrev());
        System.out.println("NEXT : "+resultDTO.isNext());
        System.out.println("TOTAL : "+resultDTO.getTotalPage());
  
        System.out.println("============================================");

        for(MemberDTO memberDTO : resultDTO.getDtoList()){
            System.out.println(memberDTO);
        }
    }
}
