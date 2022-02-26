package com.ds.phoncnic.service;

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
