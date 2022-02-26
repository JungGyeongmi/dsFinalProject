package com.ds.phoncnic.service;

import com.ds.phoncnic.dto.MyPageDTO;
import com.ds.phoncnic.entity.CharacterLook;
import com.ds.phoncnic.entity.Member;
import com.ds.phoncnic.repository.CharacterLookRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService{
    private final CharacterLookRepository repository;

    @Override
    public  MyPageDTO get(String id){
        Object result = repository.getMypageData(id);
        Object[] arr = (Object[])result;

        return entityToDTO((Member)arr[0],(Member)arr[1], (CharacterLook)arr[2],(CharacterLook)arr[3]);

    };

   
}
