package com.ds.phoncnic.repository;

import java.util.stream.IntStream;

import com.ds.phoncnic.entity.Dyning;
import com.ds.phoncnic.entity.DyningImage;
import com.ds.phoncnic.entity.Member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DyningImageRepositoryTests {

    @Autowired
    DyningImageRepository dyningImageRepository;

    @Autowired
    DyningRepository dyningRepository;

    @Test
    public void insertImage() {

        IntStream.rangeClosed(1, 10).forEach(i -> {

            Dyning dyning = Dyning.builder().ceoid(
                    Member.builder().id("user" + i + "@icloud.com").build())
                    .build();
            
            dyningRepository.save(dyning);

            DyningImage dyningImage = DyningImage.builder()
                    .menuimagename(i + "menuimagename.jpg")
                    .menuimagepath("menuimagepath" + i)
                    .backgroundname(i + "backgroundname.jpg")
                    .backgroundpath("backgroundpath" + i)
                    .dyning(dyning)
                    .build();

            dyningImageRepository.save(dyningImage);

        });
    }
}
