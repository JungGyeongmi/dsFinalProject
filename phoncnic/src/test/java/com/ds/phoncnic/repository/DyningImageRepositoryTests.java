package com.ds.phoncnic.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DyningImageRepositoryTests {

    @Autowired
    DyningImageRepository dyningImageRepository;

    @Autowired
    DyningRepository dyningRepository;

}
