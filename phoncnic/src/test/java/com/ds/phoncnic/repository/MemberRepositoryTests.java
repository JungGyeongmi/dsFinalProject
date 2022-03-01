package com.ds.phoncnic.repository;

import java.util.Arrays;
import java.util.stream.IntStream;

import com.ds.phoncnic.entity.Member;
import com.ds.phoncnic.service.MyPageService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    CharacterLookRepository repository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MyPageService memberService;

    @Test
    public void insertDummies() {

        IntStream.rangeClosed(1, 10).forEach(
            i-> {
                Member member = Member.builder()
                .id("user"+i+"@icloud.com")
                .nickname("user"+i)
                .password("1234")
                .build();

                memberRepository.save(member);
            }  

        );

    }

    
    /* 페이징테스트 */
    // @Test
    // public void testList() {
    //     PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

    //     PageResultDTO<MemberDTO, Member> resultDTO = memberService.getList(pageRequestDTO);
        
    //     System.out.println("PREV : "+resultDTO.isPrev());
    //     System.out.println("NEXT : "+resultDTO.isNext());
    //     System.out.println("TOTAL : "+resultDTO.getTotalPage());
  
    //     System.out.println("============================================");

    //     for(MemberDTO memberDTO : resultDTO.getDtoList()){
    //         System.out.println(memberDTO);
    //     }
    // }

    // @Test
    // public void testGetmypage(){
    //     String ii = "user10@icloud.com";
    //     List<Object[]> result = repository.getmypage(ii);
    //     for(Object[] arr : result){
    //         System.out.println(Arrays.toString(arr));
    //     }
    // }


//     @Test
//     public void testGetmypage() {
//         String ii = "user10@icloud.com";
//    Object result = repository.getmypage(ii);
//    Object[] arr = (Object[])result;
//    System.out.println(Arrays.toString(arr));
//  }

// @Test
// public void getMypageData() {

//     Object result = repository.getMypageData("user1@icloud.com");
//     Object[] arr = (Object[])result;
//     System.out.println(arr[0]);
//     System.out.println(arr[1]);
// }

}
