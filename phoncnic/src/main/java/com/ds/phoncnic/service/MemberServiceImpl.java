package com.ds.phoncnic.service;

import java.util.Optional;

import com.ds.phoncnic.dto.MemberDTO;
import com.ds.phoncnic.entity.CharacterLook;
import com.ds.phoncnic.entity.Member;
import com.ds.phoncnic.repository.CharacterLookRepository;
import com.ds.phoncnic.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    @Autowired
    private CharacterLookRepository characterLookRepository;

    @Autowired
    private MemberRepository memberRepository;
    
    // @Override
    // public PageResultDTO<MemberDTO, Member> getList(PageRequestDTO pageRequestDTO){
    //     //원하는 페이지 번호와 갯수를 정렬과 합께 초기화
    //     Pageable pageable = pageRequestDTO.getPageable(Sort.by("regDate").descending());
    //     //result를 레파지토리 초기화된 pageable과 repository의 findAll메서드를 통해 담음

    //     Page<Member> result = memberRepository.findAll(pageable);//Querydsl 사용
        
    //     Function<Member,MemberDTO> fn = (member -> entitiesToDTO(member);
    //     //pageResultDTO의 생성자를 통해 list타입의 멤버변수에 결과를 담음.
    //     return new PageResultDTO<>(result, fn);        
        
    // }

    @Override
  public MemberDTO getMyPage(String id) {
    Object result = characterLookRepository.getMypageData(id);    
    Object[] arr = (Object[])result;
    // return entitiesToDTO((String)arr[1], (String)arr[2], (Long)arr[3],(Long)arr[4]);
    return entitiesToMyPageDTO((Member)arr[0],(CharacterLook)arr[1]);
    
  }


  @Override
    public void modify(MemberDTO memberDTO) {
        //데이터를 불러올때 옵샤날~~~~
        Optional<Member> result = memberRepository.findById(memberDTO.getId());
        //수정시에는 반드시 먼저 값을 불러오고 나서 불러올 수 있다.
        if(result.isPresent()){
            Member member = result.get();
            member.changeNickname(memberDTO.getId());

            memberRepository.save(member);
        }

    }
  
    
   
        
}
