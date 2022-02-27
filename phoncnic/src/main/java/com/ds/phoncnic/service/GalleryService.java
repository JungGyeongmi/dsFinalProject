package com.ds.phoncnic.service;

import java.util.List;
import java.util.stream.Collectors;

import com.ds.phoncnic.dto.GalleryDTO;
import com.ds.phoncnic.dto.GalleryImageDTO;
import com.ds.phoncnic.dto.PageRequestDTO;
import com.ds.phoncnic.dto.PageResultDTO;
import com.ds.phoncnic.entity.Gallery;
import com.ds.phoncnic.entity.GalleryImage;
import com.ds.phoncnic.entity.Member;

public interface GalleryService {
    PageResultDTO<GalleryDTO, Object[]> getList(PageRequestDTO PageRequestDTO);

    default Gallery dtoToEntity(GalleryDTO galleryDTO) {
      
        // Map<String, Object> entityMap = new HashMap<>();

        Gallery gallery = Gallery.builder()
        .gno(galleryDTO.getGno())
        .title(galleryDTO.getTitle())
        .content(galleryDTO.getContent())
        .imagetype(galleryDTO.isImagetype())
        .imagepath(galleryDTO.getImagepath())
        .artistid(
            Member.builder()
            .id(galleryDTO.getId())
            .build()
        )
        .image(GalleryImage.builder()
            .gno(galleryDTO.getGno())
            .build())
        .build();
        
        // entityMap.put("gallery", gallery);

        return gallery;
    }

    default GalleryDTO entityToDTO(Gallery gallery, List<GalleryImage> galleryImages) {
        

        List<GalleryImageDTO> galleryImagyDTOList = galleryImages.stream()
            .map(galleryImage -> {
                return GalleryImageDTO.builder()
                    .id(galleryImage.getArtistid().getId())
                    .gno(galleryImage.getGno())
                    .imagename(galleryImage.getImagename())
                    .imagepath(galleryImage.getImagepath())
                .build();
            }).collect(Collectors.toList());

        GalleryDTO galleryDTO = GalleryDTO.builder()
            .gno(gallery.getGno())
            .title(gallery.getTitle())
            .content(gallery.getContent())
            .imagetype(gallery.isImagetype())
            .imagepath(gallery.getImagepath())
            .id(gallery.getArtistid().getId())
            .regDate(gallery.getRegDate())
            .modDate(gallery.getModDate())
            // .galleryimageDTOList(gallery.getImage())
            .build();

            galleryDTO.setGalleryimageDTOList(galleryImagyDTOList);

            return galleryDTO;
        }
}
