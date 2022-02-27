package com.ds.phoncnic.service;

import com.ds.phoncnic.repository.GalleryImageRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GalleryImageServiceImpl implements GalleryImageService {
    
    private final GalleryImageRepository galleryImageRepository;

    @Override
    public void delteGalleryImageByGalleryGno(long gno) {
        galleryImageRepository.deleteByGno(gno);
    }

}
