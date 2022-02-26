package com.ds.phoncnic.repository;

import java.util.stream.IntStream;

import com.ds.phoncnic.entity.Dyning;
import com.ds.phoncnic.entity.DyningImage;
import com.ds.phoncnic.entity.Member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DyningRepositoryTests {

    @Autowired
    DyningRepository dyningRepository;

    // @Autowired
    // MemberRepository memberRepository;

    // @Autowired
    // DyningImageRepository dyningImageRepository;

    @Autowired
    DyningImageRepository dyningImageRepository;

    @Test
    public void insertDyning() {

        IntStream.rangeClosed(1, 10).forEach(i -> {

            Member member = Member.builder().id("user" + i + "@icloud.com").build();

            Dyning dyning = Dyning.builder()
                    .dyningname("가게이름" + i)
                    .roofdesign((int) (Math.random() * 5)) // 지붕 디자인 0~5
                    .location("실제가게위치" + i)
                    .foodtype((int) (Math.random() * 5)) // 음식점 종류 0~5
                    .businesshours("영업시간" + i)
                    .comment("사장님 한 마디" + i)
                    .hashtag("해쉬태그" + i)
                    .ceoid(member)
                    .build();

            dyningRepository.save(dyning);

            for (int j = 0; j < Math.random() * 3; j++) {
                DyningImage dyningImage = DyningImage.builder()
                        .menuimagename(j + "menuimagename.jpg")
                        .menuimagepath("menuimagepath" + j)
                        .backgroundname(j + "backgroundname.jpg")
                        .backgroundpath("backgroundpath" + j)
                        .dyning(dyning)
                        .build();
                dyningImageRepository.save(dyningImage);
            }
        });
    }
}