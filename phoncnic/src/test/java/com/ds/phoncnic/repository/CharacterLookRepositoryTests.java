package com.ds.phoncnic.repository;


import java.util.Optional;
import java.util.stream.IntStream;

import com.ds.phoncnic.entity.CharacterLook;
import com.ds.phoncnic.entity.Member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;


@SpringBootTest
@Log4j2
public class CharacterLookRepositoryTests {
    @Autowired
    CharacterLookRepository repository;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 10).forEach(
            i-> {
                Member member = Member.builder()
                .id("user"+i+"@icloud.com").build();

                CharacterLook characterLook = CharacterLook.builder()
                .hair("헤어"+Integer.toString(i))
                .clothes("의상"+Integer.toString(i))
                .member(member)
                .build();

                repository.save(characterLook);
            }  

        );

    }

    // @Test
    // public  void lookData() {
    //     List<Object[]> result = repository.mypageCharacterLook("user10@icloud.com");
    //     for(Object[] arr : result){
    //         System.out.println(Arrays.toString(arr));
    //     }
      
    // }

    @Test
    public void testGetCharacterLook(){
        Optional<CharacterLook> result = repository.getCharacterLook("user10@icloud.com");
        CharacterLook characterLook = result.get();
        System.out.println(characterLook.getMember().getId());
        System.out.println(characterLook.getHair());
        System.out.println(characterLook.getClothes());
    }

//     @Test
//     public void TestGetCharacterLook() {
//         String ii ="user10@icloud.com";
//    Object result = repository.getCharacterLook(ii);
//    Object[] arr = (Object[])result;
//    System.out.println(Arrays.toString(arr));
//  }

//     @Test
//     public void testMypage() {
//         String ii ="user10@icloud.com";
//         Object result =repository.getmypage(ii);
//             System.out.println(result);

//  }

}
