package com.ds.phoncnic.repository;

import java.util.stream.IntStream;

import com.ds.phoncnic.entity.Gallery;
import com.ds.phoncnic.entity.GalleryImage;
import com.ds.phoncnic.entity.Member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GalleryRepositoryTests {

    @Autowired
    GalleryRepository galleryRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    GalleryImageRepository galleryImageRepository;

    @Test
    public void insertDummise(){

        IntStream.rangeClosed(1, 10).forEach(i->{
            boolean rand = ((int)(Math.random()*2))!=0;

            Member member = 
                Member.builder().id(
                    memberRepository.findById("user"+i+"@icloud.com").get().getId()
                )
            .build();

            GalleryImage galleryImage = GalleryImage.builder()
                .imagename("imagename"+i)
                .imagepath(i+"imagepath.jpg")
                .member(member)
            .build(); 
            
            Gallery gallery = Gallery.builder()
                .title(i+"title")
                .content(i+"content")
                .imagetype(rand)
                .imagepath(galleryImage.getImagepath())
                .artistid(galleryImage.getMember())
                .image(galleryImage)
            .build();

            galleryRepository.save(gallery);
            galleryImageRepository.save(galleryImage);
        }
        );

    }

}
