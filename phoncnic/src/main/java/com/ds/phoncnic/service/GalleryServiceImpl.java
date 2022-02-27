package com.ds.phoncnic.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import com.ds.phoncnic.dto.GalleryDTO;
import com.ds.phoncnic.dto.PageRequestDTO;
import com.ds.phoncnic.dto.PageResultDTO;
import com.ds.phoncnic.entity.Gallery;
import com.ds.phoncnic.entity.GalleryImage;
import com.ds.phoncnic.repository.GalleryRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GalleryServiceImpl implements GalleryService {
   
    private final GalleryRepository galleryRepository;
   
    @Override
    public PageResultDTO<GalleryDTO, Object[]> getList(PageRequestDTO PageRequestDTO) {
        Pageable pageable = PageRequestDTO.getPageable(Sort.by("regDate").descending());

        Page<Object[]> result = galleryRepository.getListPage(pageable);
        
        Function<Object[], GalleryDTO> fn = (arr -> entityToDTO(
            (Gallery) arr[0],
            (List<GalleryImage>) (Arrays.asList((GalleryImage) arr[1]))
            ));
        
        return new PageResultDTO<>(result, fn);
    }
}
