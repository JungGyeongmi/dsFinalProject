package com.ds.phoncnic.repository;

import java.util.stream.IntStream;

import com.ds.phoncnic.entity.Dyning;
import com.ds.phoncnic.entity.Emoji;
import com.ds.phoncnic.entity.Gallery;
import com.ds.phoncnic.entity.Member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class EmojiRepositoryTests {

    @Autowired
    EmojiRepository emojiRepository;

    @Transactional
    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1, 10).forEach(i->{
 ;
            Gallery gallery = Gallery.builder().gno((long)i).build();
            Member member = Member.builder().id("user"+i+"iclooud.com").build();
            
            int rand = (int)(Math.random()*5)+1;
            
            for(int j = 0; j<rand; j++){
                Emoji emoji = Emoji.builder()
                    .emojitype(j+"int변경")
                    .gallery(gallery)
                    .member(member)
                .build();
                emojiRepository.save(emoji);
            }
        });
    }


}
