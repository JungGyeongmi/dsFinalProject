package com.ds.phoncnic.service;

import com.ds.phoncnic.repository.CharacterLookInfoRepository;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CharacterLookServiceImpl implements CharacterLookService{
    @Autowired
    private CharacterLookInfoRepository CharacterLookInfoRepository;
    
    
}
