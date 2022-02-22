package com.ds.phoncnic.repository;

import java.util.stream.IntStream;

import com.ds.phoncnic.entity.Member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    MemberRepository repository;

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

}
