package com.ds.phoncnic.repository;

import java.util.stream.IntStream;

import com.ds.phoncnic.entity.Dyning;
import com.ds.phoncnic.entity.Follow;
import com.ds.phoncnic.entity.Gallery;
import com.ds.phoncnic.entity.Member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class FollowRepositoryTests {

    @Autowired
    FollowRepository followRepository;

    @Transactional
    @Test
    public void insertDummies() {

        IntStream.rangeClosed(1, 30).forEach(i->{

            int rand = (int)(Math.random()*10)+1;
            
            Dyning dyning = Dyning.builder().dno(rand).build();
            Gallery gallery = Gallery.builder().gno((long)rand).build();
            Member member = Member.builder().id("user"+rand+"iclooud.com").build();
            
            
            rand = (int)(Math.random()*10)+1;

            Follow follow = Follow.builder()
                .followid("user"+rand+"@iclouc.com")
                .dyning(dyning)
                .gallery(gallery)
                .follower(member)
            .build();

            followRepository.save(follow);
        }); 
    }

}
