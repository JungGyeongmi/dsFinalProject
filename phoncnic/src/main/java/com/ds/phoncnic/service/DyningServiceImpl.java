package com.ds.phoncnic.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.ds.phoncnic.dto.DyningDTO;
import com.ds.phoncnic.dto.PageRequestDTO;
import com.ds.phoncnic.dto.PageResultDTO;
import com.ds.phoncnic.entity.Dyning;
import com.ds.phoncnic.entity.DyningImage;
import com.ds.phoncnic.repository.DyningImageRepository;
import com.ds.phoncnic.repository.DyningRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class DyningServiceImpl implements DyningService {
    
    private final DyningRepository dyningRepository;
    private final DyningImageRepository dyningImageRepository;

    @Transactional
    @Override
    public Long register(DyningDTO dyningdDTO) {
        log.info("dyning/setting/register....");
        Map<String, Object> entityMap = dtoToEntity(dyningdDTO);
        Dyning dyning = (Dyning) entityMap.get("dyning");
        List<DyningImage> dyningImageList = (List<DyningImage>) entityMap.get("dyningImageList");
        dyningRepository.save(dyning);
        dyningImageList.forEach(dyningImage -> {
            dyningImageRepository.save(dyningImage);
        });
        return dyning.getDno();
    }


    @Override
    public PageResultDTO<DyningDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
        
        Pageable pageable = pageRequestDTO.getPageable(Sort.by("dno"));

        Page<Object[]> result = dyningRepository.getListPage(pageable);

        Function<Object[], DyningDTO> fn = (arr -> entityToDTO(
            (Dyning) arr[0], 
            (List<DyningImage>) (Arrays.asList((DyningImage) arr[1]))
            ));

        return new PageResultDTO<>(result, fn);
    }
    
}
