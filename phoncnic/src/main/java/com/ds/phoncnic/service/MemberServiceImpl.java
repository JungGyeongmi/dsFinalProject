package com.ds.phoncnic.service;

import java.util.function.Function;

import com.ds.phoncnic.dto.MemberDTO;
import com.ds.phoncnic.dto.PageRequestDTO;
import com.ds.phoncnic.dto.PageResultDTO;
import com.ds.phoncnic.entity.Member;
import com.ds.phoncnic.repository.MemberRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    
    @Override
    public PageResultDTO<MemberDTO, Member> getList(PageRequestDTO pageRequestDTO){
        //원하는 페이지 번호와 갯수를 정렬과 합께 초기화
        Pageable pageable = pageRequestDTO.getPageable(Sort.by("regDate").descending());
        //result를 레파지토리 초기화된 pageable과 repository의 findAll메서드를 통해 담음

        Page<Member> result = memberRepository.findAll(pageable);//Querydsl 사용
        
        Function<Member,MemberDTO> fn = (member -> entityToDTO(member));
        //pageResultDTO의 생성자를 통해 list타입의 멤버변수에 결과를 담음.
        return new PageResultDTO<>(result, fn);        
        
    }
    
    // @Override
    // public MyPageDTO get(String id){
    //         Object result = memberRepository.getmypage(id);
    //         Object[] arr = (Object[]) result;
    //         return entityToMyPageDTO((Member)arr[0],(Member)arr[1],(CharacterLook)arr[2],(CharacterLook)arr[3]);

    // }
        
}
