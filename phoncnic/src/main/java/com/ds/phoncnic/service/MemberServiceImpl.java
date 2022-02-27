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

@Service
@RequiredArgsConstructor
// @Log4j2
public class MemberServiceImpl implements MemberService {
  @Autowired
  private CharacterLookRepository characterLookRepository;

  @Autowired
  private MemberRepository memberRepository;

  @Override
  public MemberDTO getMyPage(String id) {
    Object result = characterLookRepository.getMypageData(id);
    Object[] arr = (Object[]) result;
    return entitiesToMyPageDTO((Member) arr[0], (CharacterLook) arr[1]);
  }

  @Override
  public void modify(MemberDTO memberDTO) {
    // 데이터를 불러올때 옵샤날~~~~
    Optional<Member> result = memberRepository.findById(memberDTO.getId());
    // 수정시에는 반드시 먼저 값을 불러오고 나서 불러올 수 있다.
    if (result.isPresent()) {
      Member member = result.get();
      member.changeNickname(memberDTO.getId());

      memberRepository.save(member);
    }

  }

}
