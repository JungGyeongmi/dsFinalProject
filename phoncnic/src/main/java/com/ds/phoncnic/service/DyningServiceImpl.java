package com.ds.phoncnic.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import com.ds.phoncnic.dto.DyningDTO;
import com.ds.phoncnic.dto.PageRequestDTO;
import com.ds.phoncnic.dto.PageResultDTO;
import com.ds.phoncnic.entity.Dyning;
import com.ds.phoncnic.entity.DyningImage;
import com.ds.phoncnic.repository.DyningRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DyningServiceImpl implements DyningService {
    
    // private final DyningRepository dyningRepository;

    // @Override
    // public PageResultDTO<DyningDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
        
    //     Pageable pageable = pageRequestDTO.getPageable(Sort.by("gno").descending());
       
    //     Page<Object[]> result = dyningRepository.getListPage(pageable);

    //     Function<Object[], DyningDTO> fn = (arr -> entityToDTO(
    //         (Dyning) arr[0], 
    //         (List<DyningImage>) (Arrays.asList((DyningImage) arr[1]))
    //         ));

    //     return new PageResultDTO<>(result, fn);
    // }
    
}
