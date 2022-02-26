package com.ds.phoncnic.repository;

import com.ds.phoncnic.entity.Dyning;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DyningRepository extends JpaRepository<Dyning, Long>{
    
    // @Query("select d, di from Dyning d inner join DyningImage di on di.dno = d.dno group by d")
    // Page<Object[]> getListPage(Pageable pageable);
}
